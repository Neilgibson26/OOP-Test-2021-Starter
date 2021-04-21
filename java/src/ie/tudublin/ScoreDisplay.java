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

	//	Function that loads the scores from the string onto the array list and their durations.
	void loadScore ()
	{
		int currentDuration;
		char currNote = score.charAt(0);
		char nextNote = score.charAt(1);
		for(int i = 0; i<score.length(); i++)
		{
			currNote = score.charAt(i);
			if(i < score.length()-2)
			{
				nextNote = score.charAt(i+1);
			}
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

			// Draw bases on note, 8 if statements


			if(notes.get(i).getNote() == 'D') //Checking what note it is, then load y co-ord form array list
			{	
				y = noteY.get(0);
				if(mouseX>x && mouseX<(x+20))
				{	
					fill(255,0,0);
					stroke(255,0,0);
				}
				else { 
					fill(0);
					stroke(0);
				}

				circle(x+10, y + 11, 20);
				line(x + 17, y + 11, x + 17, y - 60);
				text(notes.get(i).getNote(), x+10, letters);
				//	Check if Quaver or Crotchet
				if(notes.get(i).getDuaration()<2)
				{
					line(x+17, y-60, x+25, y-40);
				}
			}
			if(notes.get(i).getNote() == 'E') //Checking what note it is, then load y co-ord form array list
			{
				y = noteY.get(0);
				if(mouseX>x && mouseX<(x+20))
				{	
					fill(255,0,0);
					stroke(255,0,0);
				}
				else { 
					fill(0);
					stroke(0);
				}

				circle(x+10, y, 20);
				line(x + 17, y, x + 17, y - 60);
				text(notes.get(i).getNote(), x+10, letters);
				//	Check if Quaver or Crotchet
				if(notes.get(i).getDuaration()<2)
				{
					line(x+17, y-60, x+25, y-40);
				}
			}
			if(notes.get(i).getNote() == 'F') //Checking what note it is, then load y co-ord form array list
			{
				y = noteY.get(1);
				if(mouseX>x && mouseX<(x+20))
				{	
					fill(255,0,0);
					stroke(255,0,0);
				}
				else { 
					fill(0);
					stroke(0);
				}

				circle(x+10, y + 11, 20);
				line(x + 17, y + 11, x + 17, y - 60);
				text(notes.get(i).getNote(), x+10, letters);
				//	Check if Quaver or Crotchet
				if(notes.get(i).getDuaration()<2)
				{
					line(x+17, y-60, x+25, y-40);
				}
			}
			if(notes.get(i).getNote() == 'G') //Checking what note it is, then load y co-ord form array list
			{
				y = noteY.get(1);

				//	check if mouse is in range to fill note
				if(mouseX>x && mouseX<(x+20))
				{	
					fill(255,0,0);
					stroke(255,0,0);
				}
				else { 
					fill(0);
					stroke(0);
				}
				circle(x+10, y, 20);
				line(x + 17, y, x + 17, y - 60);
				text(notes.get(i).getNote(), x+10, letters);

				//	Check if Quaver or Crotchet
				if(notes.get(i).getDuaration()<2)
				{
					line(x+17, y-60, x+25, y-40);
				}
			}

			if(notes.get(i).getNote() == 'A') //Checking what note it is, then load y co-ord form array list
			{
				//y = map(A,1,8,)
				y = noteY.get(2);
				if(mouseX>x && mouseX<(x+20))
				{	
					fill(255,0,0);
					stroke(255,0,0);
				}
				else { 
					fill(0);
					stroke(0);
				}
				circle(x+10, y + 11, 20);
				line(x + 17, y + 11, x + 17, y - 60);
				text(notes.get(i).getNote(), x+10, letters);
				//	Check if Quaver or Crotchet
				if(notes.get(i).getDuaration()<2)
				{
					line(x+17, y-60, x+25, y-40);
				}
			}

			if(notes.get(i).getNote() == 'B') //Checking what note it is, then load y co-ord form array list
			{
				y = noteY.get(2);
				if(mouseX>x && mouseX<(x+20))
				{	
					fill(255,0,0);
					stroke(255,0,0);
				}
				else { 
					fill(0);
					stroke(0);
				}

				circle(x+10, y, 20);
				line(x + 17, y, x + 17, y - 60);
				text(notes.get(i).getNote(), x+10, letters);
				//	Check if Quaver or Crotchet
				if(notes.get(i).getDuaration()<2)
				{
					line(x+17, y-60, x+25, y-40);
				}
			}

			if(notes.get(i).getNote() == 'c') //Checking what note it is, then load y co-ord form array list
			{
				y = noteY.get(2);
				if(mouseX>x && mouseX<(x+20))
				{	
					fill(255,0,0);
					stroke(255,0,0);
				}
				else { 
					fill(0);
					stroke(0);
				}
				circle(x+10, y - 11, 20);
				line(x + 17, y - 11, x + 17, y - 60);
				text(notes.get(i).getNote(), x+10, letters);

				//	Check if Quaver or Crotchet
				if(notes.get(i).getDuaration()<2)
				{
					line(x+17, y-60, x+25, y-40);
				}
			}

			if(notes.get(i).getNote() == 'd') //Checking what note it is, then load y co-ord form array list
			{
				y = noteY.get(3);
				if(mouseX>x && mouseX<(x+20))
				{	
					fill(255,0,0);
					stroke(255,0,0);
				}
				else { 
					fill(0);
					stroke(0);
				}

				circle(x+10, y - 11, 20);
				line(x + 17, y - 11, x + 17, y - 60);
				text(notes.get(i).getNote(), x+10, letters);
				//	Check if Quaver or Crotchet
				if(notes.get(i).getDuaration()<2)
				{
					line(x+17, y-60, x+25, y-40);
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
