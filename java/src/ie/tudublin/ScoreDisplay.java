package ie.tudublin;

import java.util.ArrayList;


import processing.core.PApplet;

public class ScoreDisplay extends PApplet
{
	float D = 8;
	float E = 7;
	float F = 6;
	float G = 5;
	float A = 4;
	float B = 3;
	float c = 2;
	float d = 1;
	//String score = "DEFGABcd";
	//String score = "D2E2F2G2A2B2c2d2";
	String score = "DEF2F2F2EFA2A2B2AFD2E2D2D2D2";
	ArrayList<Note> notes = new ArrayList<Note>();
	ArrayList<Float> noteY = new ArrayList<Float>();
	float border = 100;
	float tborder = 300;
	
	
	public void settings()
	{
		size(1000, 500);

		// How to convert a character to a number
		char c = '7'; // c holds the character 7 (55)
		int i = c - '0'; // i holds the number 7 (55 - 48) 
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
		char currNote;
		char nextNote;
		for(int i = 0; i<score.length()-1; i++)
		{
			currNote = score.charAt(i);
			nextNote = score.charAt(i+1);
			currentDuration = 1;
			if(Character.isDigit(nextNote))
			{
				currentDuration = 2;
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
			line(border, y, width-border, y);

		}

	}

	//	Function to draw the notes on top of the lines
	public void drawNotes()
	{
		float x, letters;
		float y2;

		letters = tborder / 2;

		//	Looping through the notes array list to draw it onto the board
		for(int i = 0; i<notes.size(); i++)
		{
			//	Mapping to get the x co-ordinate for each note.
			x = map(i, 0, notes.size(), border, width-border);
			text(notes.get(i).getNote(), x, letters);



			if(notes.get(i).getNote() == 'A') //Checking what note it is, then load y co-ord form array list
			{
				//y = map(A,1,8,)
				y2 = noteY.get(2);

				fill(0);
				circle(x+10, y2 + 11, 20);
				line(x + 17, y2 + 11, x + 17, y2 - 50);
				//	Check if Quaver or Crotchet
				if(notes.get(i).getDuaration()<2)
				{
					line(x+17, y2-50, x+25, y2-40);
				}
			}
			if(notes.get(i).getNote() == 'B') //Checking what note it is, then load y co-ord form array list
			{
				y2 = noteY.get(2);

				fill(0);
				circle(x+10, y2, 20);
				line(x + 17, y2, x + 17, y2 - 60);
				//	Check if Quaver or Crotchet
				if(notes.get(i).getDuaration()<2)
				{
					line(x+17, y2-50, x+25, y2-40);
				}
			}
			if(notes.get(i).getNote() == 'D') //Checking what note it is, then load y co-ord form array list
			{	
				y2 = noteY.get(0);

				fill(0);
				circle(x+10, y2 + 11, 20);
				line(x + 17, y2 + 11, x + 17, y2 - 50);
				//	Check if Quaver or Crotchet
				if(notes.get(i).getDuaration()<2)
				{
					line(x+17, y2-50, x+25, y2-40);
				}
			}
			if(notes.get(i).getNote() == 'E') //Checking what note it is, then load y co-ord form array list
			{
				y2 = noteY.get(0);

				fill(0);
				circle(x+10, y2, 20);
				line(x + 17, y2, x + 17, y2 - 50);
				//	Check if Quaver or Crotchet
				if(notes.get(i).getDuaration()<2)
				{
					line(x+17, y2-50, x+25, y2-40);
				}
			}
			if(notes.get(i).getNote() == 'F') //Checking what note it is, then load y co-ord form array list
			{
				y2 = noteY.get(1);

				fill(0);
				circle(x+10, y2 + 11, 20);
				line(x + 17, y2 + 11, x + 17, y2 - 50);
				//	Check if Quaver or Crotchet
				if(notes.get(i).getDuaration()<2)
				{
					line(x+17, y2-50, x+25, y2-40);
				}
			}
		}
	}

	//Getting the y co-ordinates of each line to be able to locate where each note will be drawn
	public void getNoteY()
	{
		float y,x;
		for(int i = 0; i<5; i++)
		{
			y = map(i, 0, 4, tborder, height - tborder);
			noteY.add(y);
		}
	}

}
