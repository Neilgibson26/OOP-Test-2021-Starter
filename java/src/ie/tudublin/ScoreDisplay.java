package ie.tudublin;

import java.util.ArrayList;
import java.util.HashMap;

import processing.core.PApplet;

public class ScoreDisplay extends PApplet
{
	// String score = "DEFGABcd";
	// String score = "D2E2F2G2A2B2c2d2";
	String score = "DEF2F2F2EFA2A2B2AFD2E2D2D2D2";
	ArrayList<Note> notes = new ArrayList<Note>();

	//	Hashmap to store notes and their y values as a key and value to access later.
	HashMap<Character, Float> yVal = new HashMap<Character, Float>();
	float border = 100;
	float tborder = 300;
	
	
	public void settings()
	{
		size(1000, 500);

	}

	public void setup() 
	{
		loadScore();
		printScores();
		getNoteY();
	}

	public void draw()
	{
		background(255);
		drawLines();
		drawNotes();
		
	}

	//	Function that loads the scores from the string onto the array list and their durations.
	void loadScore ()
	{
		int currentDuration;
		char currNote = score.charAt(0);
		char nextNote = score.charAt(1);
		for(int i = 0; i<score.length(); i++)
		{
			currNote = score.charAt(i);
			//	Bounds checking here
			if(i < score.length()-2)
			{
				nextNote = score.charAt(i+1);
			}
			currentDuration = 1;
			if(Character.isDigit(nextNote))
			{
				currentDuration = nextNote - '0';
				i+=1;
			}
			Note n = new Note(currentDuration, currNote);
			notes.add(n);
		}

	}
	//Function that prints the scores of the of each note
	void printScores()
	{
		Note n;
		int d;
		for(int j = 0; j<notes.size(); j++)
		{
			n = notes.get(j);
			d = n.getDuaration();
			//	in-line if to decide which toString to print out
			System.out.println(d == 2 ? n.toStringC():n.toStringQ());
		}
	}
	//Function to draw lines onto the board
	void drawLines()
	{
		float y;
		for(int i = 0; i<5; i++)
		{
			y = map(i, 0, 4, tborder, height - tborder);
			stroke(0);
			line(border, y, width-border, y);

		}

	}

	//	Function to draw the notes on top of the lines
	public void drawNotes()
	{
		float x, letters;
		float y;

		letters = tborder / 2;

		//	Looping through the notes array list to draw it onto the board
		for(int i = 0; i<notes.size(); i++)
		{
			//	Mapping to get the x co-ordinate for each note and letter.
			x = map(i, 0, notes.size(), border, width-border);
			y = yVal.get(notes.get(i).getNote()); //  get the y co-ordinate by using the note as a key.
			if(mouseX>x && mouseX<(x+20)) //  Check if the mouse is in the radius of a note, if so turn red.
			{	
				fill(255,0,0);
				stroke(255,0,0);
			}
			else { 
				fill(0);
				stroke(0);
			}
			circle(x+10, y + 11, 20);
			line(x + 17, y + 11, x + 17, y - 50);
			text(notes.get(i).getNote(), x+10, letters);
			if(notes.get(i).getDuaration()<2)
				{
					line(x+17, y-50, x+25, y-30);
				}
			
		}
	}

	//Getting the y co-ordinates of each line to be able to locate where each note will be drawn
	public void getNoteY()
	{
		float y;

		//	Iterate through array list to add key and value
		for(int i = notes.size()-1; i>=0; i--)
		{
			y = map(i, 0, 10, tborder, height-tborder);
			yVal.put(notes.get(i).getNote(), y);
		}
	}

}
