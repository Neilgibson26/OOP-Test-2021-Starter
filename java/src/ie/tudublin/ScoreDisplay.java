package ie.tudublin;

import java.util.ArrayList;


import processing.core.PApplet;

public class ScoreDisplay extends PApplet
{
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

	void printScores()
	{
		Note n;
		int d;
		for(int j = 0; j<notes.size(); j++)
		{
			n = notes.get(j);
			d = n.getDuaration();
			System.out.println(d == 2 ? n.toStringC():n.toStringQ());
		}
	}

	void drawLines()
	{
		float y;
		for(int i = 0; i<5; i++)
		{
			y = map(i, 0, 4, tborder, height - tborder);
			line(border, y, width-border, y);

		}

	}

	public void drawNotes()
	{
		float x;
		for(int i = 0; i<notes.size(); i++)
		{
			x = map(i, 0, notes.size(), border, width-border);
			if(notes.get(i).getNote() == 'A')
			{
				circle(x, noteY.get(2), 30);
			}
		}
	}

	public void getNoteY()
	{
		float y;
		for(int i = 0; i<5; i++)
		{
			y = map(i, 0, 4, tborder, height - tborder);
			noteY.add(y);


		}
	}

}
