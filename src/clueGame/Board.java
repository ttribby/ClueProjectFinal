package clueGame;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

import clueGame.Card.CardType;
import clueGame.RoomCell.DoorDirection;

public class Board extends JPanel{
	ArrayList<BoardCell> cells = new ArrayList<BoardCell>();
	//changed rooms to hashmap
	public Set<Card> solution;
	Map<Character, String> rooms = new HashMap<Character, String>();
	Map<Integer, LinkedList<Integer>> adjacencies = new HashMap<Integer, LinkedList<Integer>>();
	Set<BoardCell> targets = new HashSet<BoardCell>();
	Set<Integer> path = new HashSet<Integer>();
	public Set<Player> players;
	public Set<Player> computerPlayers;
	public HumanPlayer you = new HumanPlayer();
	static public Set<Card> deck = new HashSet<Card>();
	int numRows;
	int numColumns;
	int firstSpot;
	public int currentPlayerIndex;
	public int humanPlayerIndex;
	private boolean humanTurn;
	private int diceNum;
	private Set<BoardCell> moveLocations;
	public ClueGame clueGame;
	public boolean humanTurnWasMade;

	public void nextPlayer(BottomButtons bb,TopButtons tb){
//		p[currentPlayerIndex];
		//if it is human players turn and humanTurnWasMade = false
		if(!humanTurnWasMade && currentPlayerIndex == humanPlayerIndex){
			clueGame.invalidNeedToFinishTurn();
			return;
		}
		humanTurnWasMade = false;
		System.out.println("before incrementing = " + currentPlayerIndex);
		currentPlayerIndex = (currentPlayerIndex+1)%6;
		System.out.println("after incrementing = " + currentPlayerIndex);		
		//if player turn and not clicked display error and return
		
		// set dice view
		Random n = new Random(System.currentTimeMillis());
		int dice =n.nextInt(6)+1;
		BottomButtons.diceNum = dice;
		diceNum = dice;
		System.out.println(dice + "");
		bb.setDice(dice);
		


		//if currentPlayer is a human player then show move spaces
		if(currentPlayerIndex == humanPlayerIndex){
			System.out.println("setting human turn");
			humanTurn = true;
		}else{
			Player p[]   = new Player[6]; 
			players.toArray(p);
			Player a = p[currentPlayerIndex];
			BoardCell b = a.pickLocation(getTargets(a.index, dice));
			a.index =calcIndex( b.row, b.col);
			BoardCell bc = getCellAt((a.index));
			if(bc.isDoorway()){
				Player[] thePlayers = new Player[6];
				players.toArray(thePlayers);
				System.out.println("------------------------------in room");
				clueGame.showSuggestionPanel(rooms.get(bc.getRooomName()),thePlayers[currentPlayerIndex]);

			}

		}
		this.updateUI();
		// print whose turn
		Player p[]   = new Player[6]; 
		players.toArray(p);
		tb.setPlayersName(p[currentPlayerIndex].name);
		
	}
	
	public void firstNextPlayer(BottomButtons bb,TopButtons tb){

		//if player turn and not clicked display error and return
		
		// set dice view
		Random n = new Random(System.currentTimeMillis());
		int dice =n.nextInt(6)+1;
		BottomButtons.diceNum = dice;
		diceNum = dice;
		System.out.println(dice + "");
		bb.setDice(dice);
		


		//if currentPlayer is a human player then show move spaces
		if(currentPlayerIndex == humanPlayerIndex){
			System.out.println("setting human turn");
			humanTurn = true;
		}else{
//			Player p[]   = new Player[6]; 
//			players.toArray(p);
//
//			p[currentPlayerIndex].index = calcTargets(p[currentPlayerIndex].index,dice);
			
		}
		this.updateUI();
		// print whose turn
		Player p[]   = new Player[6]; 
		players.toArray(p);
		tb.setPlayersName(p[currentPlayerIndex].name);
	}
	public Board(ClueGame clueGame)  {
		this.clueGame = clueGame;
		try {
			loadConfigFiles("ClueBoardLegend.txt","ClueBoardLayout.txt","deck.txt");
		} catch (FileNotFoundException e) {
			System.out.println("file not found");
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (BadConfigFormatException e) {
			System.out.println("other error");
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		humanTurnWasMade = false;
		humanTurn = false;
	}

	//	
	//	@Override
	//	public void paintComponent(){
	//		
	//	}
	public void deal() { 
		int num_player = 0;
		int num_weapon = 0;
		int num_room = 0;
		Set<Card> deckCopy = deck;
		Set<Card> dealt = new HashSet<Card>();
		solution = new HashSet<Card>();

		while(solution.size() < 3) {
			String[] solCards = new String[3];
			int i = 0;
			for(Card sol: deckCopy) {
				
				
				if((sol.cardType == CardType.PLAYER) && num_player < 1 ) {
					solCards[0] = sol.name;
					solution.add(sol);
					dealt.add(sol);
					num_player++;
				}else if((sol.cardType == CardType.ROOM) && num_room < 1) {
					solCards[2] = sol.name;
					solution.add(sol);
					dealt.add(sol);
					num_room++;
				}else if((sol.cardType == CardType.WEAPON) && num_weapon < 1) {
					solCards[1] = sol.name;
					solution.add(sol);
					dealt.add(sol);
					num_weapon++;
				}	
			}
			Solution.Person = solCards[0];
			Solution.Weapon = solCards[1];
			Solution.Room = solCards[2];
		}
		
		int size = deckCopy.size();
		for(Player player: players) {
			int r = new Random().nextInt(size);
			for(Card card: deckCopy) {
				if((player.myCards.size() < 3)&& !dealt.contains(card)) {
					player.myCards.add(card);
					dealt.add(card);	
				}	
			}
		}
		Player[] thePlayers = new Player[6];
		players.toArray(thePlayers);
		
		int humanPlayer = -1;
		int i = 0;
		for(Player p : players){
			if(p.name == "Darth Vader"){
				humanPlayer =i;
				you = (HumanPlayer) thePlayers[i];
			}
			i++;
		}
		System.out.println("human player index = " + humanPlayer);
		System.out.println("human player name"  + you.name);
		currentPlayerIndex = humanPlayer;//(humanPlayer+1)%6;
		humanPlayerIndex=humanPlayer;//(humanPlayer+1)%6;
		computerPlayers = new HashSet<Player>();
		for(int j=0;j<thePlayers.length;j++){
			if(j !=humanPlayer ){
				computerPlayers.add(thePlayers[j]);
			}
		}
		addMouseListener(new CellClickedListener());
	}


	@Override
	protected void paintComponent(Graphics g) {
		// TODO Auto-generated method stub
		super.paintComponent(g);
		for(BoardCell bc: cells){
			bc.draw(g, this);
		}
		g.setColor(Color.white);
		g.drawString("Conservatory", 20,40 );
		g.drawString("Ballroom", 60, 200);
		g.drawString("Kitchen", 60, 380);
		g.drawString("Billiard Room", 160, 60);
		g.drawString("Library", 280, 60);
		g.drawString("Study", 400, 60);
		g.drawString("Hall", 400, 200);
		g.drawString("Dining Room", 200, 360);
		g.drawString("Lounge", 400, 360);
		for(Player cp: players){
			g.setColor(cp.color);
			g.fillOval (cells.get(cp.index).col*20, cells.get(cp.index).row*20, 20, 20);
			g.setColor(Color.BLACK);		
			g.drawOval (cells.get(cp.index).col*20, cells.get(cp.index).row*20, 20, 20);
		}
		System.out.println("want to pring locations");
		System.out.println(humanPlayerIndex);
		System.out.println(currentPlayerIndex);
		
		if(humanPlayerIndex ==currentPlayerIndex && !humanTurnWasMade){
		
			Player p[]   = new Player[6]; 
			players.toArray(p);
			int index = p[currentPlayerIndex].index;
			System.out.println( "index is " + index);
			Set<BoardCell> drawLocations = getTargets(index,diceNum );
			moveLocations = drawLocations;
			System.out.println("drawLocation size" + drawLocations.size());
			for(BoardCell c: drawLocations){
				g.setColor(Color.cyan);
				g.fillRect(20*c.col, 20*c.row, 20, 20);
				System.out.println("draw a location");
			}
		}

		//draw player locations	
	}
	public void loadPlayers()  {
		players = new HashSet<Player>();
		players.add (new HumanPlayer ("Darth Vader", Color.BLACK, 4));
		players.add (new ComputerPlayer ("Randy Moss", Color.CYAN, 12));
		players.add (new ComputerPlayer ("Liam Neeson", Color.RED, 18));
		players.add (new ComputerPlayer ("Michael Jordan", Color.BLUE, 160));
		players.add (new ComputerPlayer ("Teen Mom", Color.YELLOW, 184));
		players.add (new ComputerPlayer ("Fatboy Slim", Color.GREEN, 467));

	}


	public void loadConfigFiles(String legendFile, String boardFile, String deckFile) throws BadConfigFormatException, FileNotFoundException {
		loadLegend(legendFile);
		loadBoard(boardFile);
		loadDeck(deckFile);
		loadPlayers();
	}

	private void loadBoard(String boardFile) throws BadConfigFormatException, FileNotFoundException {
		FileReader reader = new FileReader(boardFile);
		Scanner scan = new Scanner(reader);
		// populate cell list
		int j = 0;
		while (scan.hasNext()) {
			String wholeString = scan.nextLine();
			if (!wholeString.contains(",")) {
				throw new BadConfigFormatException();
			}
			String[] strArr = wholeString.split(",");
			for (int i = 0; i < strArr.length; i++) {
				String str = strArr[i];
				if (str.equalsIgnoreCase("W")) {
					WalkwayCell wc = new WalkwayCell();
					wc.setCol(i);
					wc.setRow(j);
					wc.setBoardWidth(strArr.length);
					cells.add(wc);
				} else {
					RoomCell rc = new RoomCell();
					if (str.length() == 2) {
						char d = str.charAt(1);
						rc.setDoorDirection(d);
					}
					rc.setCol(i);
					rc.setRow(j);
					rc.setBoardWidth(strArr.length);
					rc.setRoom(str.charAt(0));
					cells.add(rc);
				}
			}
			numColumns = strArr.length;
			//for some reason ++j bothers me so i changed it to j++
			j++;
		}
		numRows = j;

	}

	private void loadLegend(String legendFile) throws BadConfigFormatException, FileNotFoundException {
		FileReader reader = new FileReader(legendFile);
		Scanner scan = new Scanner(reader);
		// populate legend map

		while (scan.hasNext()) {
			String wholeString = scan.nextLine();
			if (!wholeString.contains(", ")) {
				throw new BadConfigFormatException();
			}
			String[] stringArr = wholeString.split(", ");
			String character = stringArr[0];
			String room = stringArr[1];
			char c = character.charAt(0);
			rooms.put(c, room);
		}
	}

	public int calcIndex(int row, int col) {
		int index = (row * numColumns) + col;
		return index;
	}
	//added and integer called index, this would make it easier to change 
	//little bits of code just in case there are any problems
	public RoomCell getRoomCellAt(int row, int col) {
		int index = this.calcIndex(row, col);
		if (cells.get(index).isRoom()) {
			return (RoomCell) cells.get(index);
		} else {
			return null;
		}
	}

	public ArrayList<BoardCell> getCells() {
		return cells;
	}

	public Map<Character, String> getRooms() {
		return rooms;
	}

	public int getNumRows() {
		return numRows;
	}

	public int getNumColumns() {
		return numColumns;
	}

	public BoardCell getCellAt(int i) {
		return cells.get(i);
	}

	public LinkedList<Integer> getAdjList(int i) {
		if (adjacencies.containsKey(i)) {
			return adjacencies.get(i);
		}

		LinkedList<Integer> neighbors = new LinkedList<Integer>();
		int column = i % numColumns;
		int row = i / numColumns;
		BoardCell adj;
		BoardCell cell = getCellAt(i);

		adjacencies.put(i, neighbors);

		if (cell.isRoom()) {
			// only midget doorways have adjacencies, and they only have one arm, so short-circuit

			// if a door was placed facing an edge, this would be invalid, but the board should not be set up that way
			if (cell.isDoorway()) {
				switch (((RoomCell) cell).getDoorDirection()) {
				case RIGHT:
					neighbors.add(i + 1);
					break;
				case LEFT:
					neighbors.add(i - 1);
					break;
				case UP:
					neighbors.add(i - numColumns);
					break;
				case DOWN:
					neighbors.add(i + numColumns);
					break;
				}
			}
			return neighbors;
		}

		if (column > 0) {
			adj = getCellAt(i - 1);// the cell to the left

			if (adj.isWalkway() || (adj.isDoorway() && ((RoomCell) adj).getDoorDirection() == DoorDirection.RIGHT)) {
				neighbors.add(i - 1);
			}
		}

		if (column < numColumns - 1) {
			adj = getCellAt(i + 1);// the cell to the right

			if (adj.isWalkway() || (adj.isDoorway() && ((RoomCell) adj).getDoorDirection() == DoorDirection.LEFT)) {
				neighbors.add(i + 1);
			}
		}

		if (row > 0) {
			adj = getCellAt(i - numColumns);// the cell above

			if (adj.isWalkway() || (adj.isDoorway() && ((RoomCell) adj).getDoorDirection() == DoorDirection.DOWN)) {
				neighbors.add(i - numColumns);
			}
		}

		if (row < numRows - 1) {
			adj = getCellAt(i + numColumns);// the cell below

			if (adj.isWalkway() || (adj.isDoorway() && ((RoomCell) adj).getDoorDirection() == DoorDirection.UP)) {
				neighbors.add(i + numColumns);
			}
		}

		return neighbors;
	}

	public Set<BoardCell> getTargets(int i, int steps) {
		targets = new HashSet<BoardCell>();
		path.clear();
		path.add(i);
		calcTargets(i, steps);
		return targets;
	}

	public void calcTargets(int calcIndex, int steps) {
		for (Integer neighbor : getAdjList(calcIndex)) {
			if (path.contains(neighbor))
				continue;

			path.add(neighbor);

			// we include the initial cell in the righteous path, so the enlarged path size has to exceed steps by one
			if (path.size() > steps || getCellAt(neighbor).isDoorway()) {
				targets.add(getCellAt(neighbor));
			} else {
				calcTargets(neighbor, steps);
			}
			path.remove(neighbor);
		}
	}



	public HumanPlayer getYou() {
		return you;
	}

	public void loadDeck(String x) throws FileNotFoundException {
		deck = new HashSet<Card>();
		FileReader r = new FileReader(x);
		Scanner scan = new Scanner(r);
		scan.useDelimiter(",|\r\n|\n");

		while(scan.hasNext()) {
			String z = scan.next();
			String y = scan.next();
			System.out.println("--" + y + "--");
			System.out.println("--" + z + "--");
			deck.add(new Card(z, y));

		}


	}


	public Boolean checkAccusation(String Person, String Weapon, String Room){
		Boolean right = false;
		if((Person.equals(Solution.Person)) && (Weapon.equals(Solution.Weapon)) && (Room.equals(Solution.Room))){
			right =  true;
		}
		return right;
	}
	public void handleSuggestion(String room, String player, String weapon) {
		for(Player Player: players) {
			Card test = Player.disproveSuggestion(room, player, weapon);
			if(test != null) {
				System.out.println("disproved");
			}else {
				System.out.println("good news");
			}
		}
	}

	
	private class CellClickedListener implements MouseListener {
		private int x,y;
		@Override
		public void mouseClicked(MouseEvent e) {

		}

		@Override
		public void mouseEntered(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseExited(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mousePressed(MouseEvent e) {
			// TODO Auto-generated method stub
			x = e.getX();
			y = e.getY();
		}

		@Override
		public void mouseReleased(MouseEvent e) {
			// TODO Auto-generated method stub
			if(!humanTurnWasMade){
				humanTurnWasMade = true;
				if(e.getX() == x && e.getY() == y && currentPlayerIndex == humanPlayerIndex){
					int xCell = x/20;
					int yCell = y/20;
					boolean foundCell = false;
					for(BoardCell bc: moveLocations){
						if(bc.col == xCell && bc.row == yCell){
							System.out.println("you win");
							foundCell = true;
							you.index =calcIndex(yCell, xCell);
							repaint();
							//show what room your in
							if(bc.isDoorway()){
								Player[] thePlayers = new Player[6];
								players.toArray(thePlayers);
								System.out.println("------------------------------in room");
								clueGame.showSuggestionPanel(rooms.get(bc.getRooomName()),thePlayers[currentPlayerIndex]);
							}
							return;
						}
					}
					if(!foundCell){
						
						clueGame.invalidMoveClick();
						humanTurnWasMade = false;
					}
					
					System.out.println("xCell = " + xCell);
					System.out.println("yCell = " + yCell);


				}
			}
		}




	}


	
}
