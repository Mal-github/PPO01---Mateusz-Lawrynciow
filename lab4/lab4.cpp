#include <iostream>
#include <stdlib.h>
#include <time.h>
#include <vector>
#include <math.h>
#include <string>
#include <sstream>

using namespace std;

#define DICE 6
#define MAXPLAYERS 10
#define MINPLAYERS 3

class Log {
	public:
		static void info(string message = "") {
			cout << message << endl;
		}
};

class Dice {
	
	public:		
		int roll() {
			int result = (rand() % DICE) + 1;
			
			ostringstream ss;
			ss << "Dice roll: " << result;
			Log::info(ss.str());
			
			return result;
		}
};

class Pawn {
	public:
		int position;
		string name;
		
		Pawn() {}
		
		Pawn(string name) {
			this->name = name;
			this->position = 0;
			
			Log::info(name + " joined the game.");
		}
};

class Board {
	int maxPosition;
	
	public:
		
		
		vector<Pawn> pawns;
		Dice dice;
		Pawn winner;
		int turnsCounter;
		
		Board(int maxPosition) 
		{
			this->turnsCounter = 0;
			this->maxPosition = maxPosition;
		}
		
		void performTurn() {
			this->turnsCounter++;
			
			ostringstream ss;
			ss << "Turn " << this->turnsCounter;
			Log::info();
			Log::info(ss.str());
			
			for(int i = 0; i < this->pawns.size(); i++) {
				int rollResult = this->dice.roll();
				Pawn &pawn = this->pawns.at(i);
				pawn.position += rollResult;
				
				ostringstream ss;
				ss << pawn.name << " new position: " << pawn.position;
				Log::info(ss.str());
								
				if(pawn.position >= this->maxPosition) {
					this->winner = pawn;
					throw "Winner was called!";
				}
			}
		}
};

int main() {
	
	int maxPosition;
	int pawns;
	
	cout<<"Put Numbers of Players :  ";
	cin>> pawns;
		
	if(pawns>MAXPLAYERS)
	{
		cout<<"To many players,max limit is : ",MAXPLAYERS;
		return 1;
	}
	if(pawns<=MINPLAYERS)
	{
		cout<<"to few players >= ",MINPLAYERS;
		return 1;
	}
	
	cout<<"Put in Size of the board :  ";
	cin>> maxPosition;
	
	srand(time(NULL));
	
	string players[10]={"Luke Skywalker","Darth Vader","Count Dooku","Yoda","Darth Sidious","Darth Maul","Snoke","Qui-Gon Jinn","Obi-Wan Kenobi","Darth Plagueis"};
	
	Board board = Board(maxPosition);
	board.dice = Dice();
	
	for(int i=0;i<pawns;i++)
	{
		board.pawns.push_back(Pawn(players[i]));
	}

	try {
		while(true) {
			board.performTurn();
		}
	} catch(const char* exception) {
		Log::info();
		Log::info(board.winner.name + " won");
	}
	
	return 0;
}
