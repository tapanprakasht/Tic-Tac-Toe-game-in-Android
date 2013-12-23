package com.example.game;

import android.util.Log;

public class GameMain {
	private static final String TAG = null;
	public String[][] board=new String[3][3];
	
	public GameMain()
	{
		int i,j;
		for(i=0;i<3;i++)
		{
			for(j=0;j<3;j++)
			{
				board[i][j]="";
			}
		}
	}
			
	public void inputData(int x,int y,String str)
	{
		if(x==1 && y==0)
		{
			board[0][1]=str;
		}
		else if(x==2 && y==0)
		{
			board[0][2]=str;
		}
		else if(x==0 && y==1)
		{
			board[1][0]=str;
		}
		else if(x==2 && y==1)
		{
			board[1][2]=str;
		}
		else if(x==0 && y==2)
		{
			board[2][0]=str;
		}
		else if(x==1 && y==2)
		{
			board[2][1]=str;
		}
		else
		{
			board[x][y]=str;
		}
		
	}
	public String gameCheck()
	{
		///Check whether X won///////////////////////////////////////////////////////
		if(board[0][0]=="X" && board[0][1]=="X" && board[0][2]=="X")
		 {
			return("X");
			
		 }
		else if(board[1][0]=="X" && board[1][1]=="X" && board[1][2]=="X")
		 {
			return("X");
			
		 }
		else if(board[2][0]=="X" && board[2][1]=="X" && board[2][2]=="X")
		 {
			return("X");
			
		 }
		else if(board[0][0]=="X" && board[1][0]=="X" && board[2][0]=="X")
		 {
			return("X");
			
		 }
		else if(board[0][1]=="X" && board[1][1]=="X" && board[2][1]=="X")
		 {
			return("X");
			
		 }
		else if(board[0][2]=="X" && board[1][2]=="X" && board[2][2]=="X")
		 {
			return("X");
			
		 }
		else if(board[0][0]=="X" && board[1][1]=="X" && board[2][2]=="X")
		 {
			return("X");
			
		 }
		else if(board[0][2]=="X" && board[1][1]=="X" && board[2][0]=="X")
		 {
			return("X");
			
		 }
		//////////////////////////////////////////////////////////////////////
		
		//Check O won/////////////////////////////////////////////////////////
		if(board[0][0]=="O" && board[0][1]=="O" && board[0][2]=="O")
		 {
			return("O");
			
		 }
		else if(board[1][0]=="O" && board[1][1]=="O" && board[1][2]=="O")
		 {
			return("O");
			
		 }
		else if(board[2][0]=="O" && board[2][1]=="O" && board[2][2]=="O")
		 {
			return("O");
			
		 }
		else if(board[0][0]=="O" && board[1][0]=="O" && board[2][0]=="O")
		 {
			return("O");
			
		 }
		else if(board[0][1]=="O" && board[1][1]=="O" && board[2][1]=="O")
		 {
			return("O");
			
		 }
		else if(board[0][2]=="O" && board[1][2]=="O" && board[2][2]=="O")
		 {
			return("O");
			
		 }
		else if(board[0][0]=="O" && board[1][1]=="O" && board[2][2]=="O")
		 {
			return("O");
			
		 }
		else if(board[0][2]=="O" && board[1][1]=="O" && board[2][0]=="O")
		 {
			return("O");
			
		 }
		////////////////////////////////////////////////////////////////////
		return null;
		
		
	}
	
	
	public int isAllReadyExist(int x,int y)
	{
		
		if(x==1 && y==0)
		{
			if(board[0][1]=="X" || board[0][1]=="O")
			{
				return 1;
			}
		}
		else if(x==2 && y==0)
		{
			if(board[0][2]=="X" || board[0][2]=="O")
			{
				return 1;
			}
		}
		else if(x==0 && y==1)
		{
			
			if(board[1][0]=="X" || board[1][0]=="O")
			{
				return 1;
			}
		}
		else if(x==2 && y==1)
		{
			
			if(board[1][2]=="X" || board[1][2]=="O")
			{
				return 1;
			}
		}
		else if(x==0 && y==2)
		{
			
			if(board[2][0]=="X" || board[2][0]=="O")
			{
				return 1;
			}
		}
		else if(x==1 && y==2)
		{
			
			if(board[2][1]=="X" || board[2][1]=="O")
			{
				return 1;
			}
		}
		else if(board[x][y]=="X" || board[x][y]=="O")
		{
			
			return 1;
			
		}
		else
		{
			return 0;
		}
		return 0;
		 
	}
	public int isDrawGame()
	{
		if((board[0][0]=="X" || board[0][0]=="O") && (board[0][1]=="X" || board[0][1]=="O") && (board[0][2]=="X" || board[0][2]=="O") )
		{
			if((board[1][0]=="X" || board[1][0]=="O") && (board[1][1]=="X" || board[1][1]=="O") && (board[1][2]=="X" || board[1][2]=="O") )
			{
				if((board[2][0]=="X" || board[2][0]=="O") && (board[2][1]=="X" || board[2][1]=="O") && (board[2][2]=="X" || board[2][2]=="O"))
				{
					return 1;
				}
			}
		
		}
		return 0;
		
	}
	
}


