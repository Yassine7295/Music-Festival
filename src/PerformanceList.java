/**
*Yassine Khaliqui
*109050245
*Homework Assignment Number 1
*CSE 214 Recitation Section 06
*Recitation TA: Kevin Flyangolts 
*Grading TA: Zheyuan (Jeffrey) Gao;
*@author Yassine
*/
public class PerformanceList {

	private PerformanceNode head;
	private PerformanceNode cursor;
	private PerformanceNode tail;
	/**
	 * Creates a new PerformanceList object with a head node, a tail node, and a cursor node.
	 * <dt><b>Postcondition:</b><dd> This PerformanceNode has been initialized.
	 */
	public PerformanceList(){
		head = null;
		cursor = null;
		tail = null;
	}
	/**
	 * Adds a PerformanceNode to the end of the linked list.
	 * @param newPerformance: the node to be added.
	 * <dt><b>Precondition:</b><dd> This PerformanceList object has been initialized.
	 * <dt><b>Postcondition:</b><dd> The new performance has been added to the end of the list. The head, tail and cursor nodes have been updated as needed.
	 */
	public void addToEnd(PerformanceNode newPerformance){
		if(head == null){
			head = newPerformance;
			cursor = newPerformance;
			tail = newPerformance;
			newPerformance.setStartTime(0);
		}
		else{
			newPerformance.setPrev(tail);
			newPerformance.setNext(null);
			tail.setNext(newPerformance);
			cursor = newPerformance;
			tail = newPerformance;
			newPerformance.setStartTime();
		}
	}
	/**
	 * Adds a PerformanceNode right after the cursor node in the linked list.
	 * @param newPerformance: the node to be added.
	 * <dt><b>Precondition:</b><dd> This PerformanceList object has been initialized.
	 * <dt><b>Postcondition:</b><dd> The new performance has been added to the desired position in the list. The previous node is linked to the new node. The 
	 * new node is linked to the previous node. The next node is linked with the new node. The new node is linked with the next node. The head, tail and 
	 * cursor nodes have been updated as needed.
	 */
	public void addAfterCurrent(PerformanceNode newPerformance){
		if(cursor == null){
			head = newPerformance;
			cursor = newPerformance;
			tail = newPerformance;
		}
		else if(cursor == tail)
			addToEnd(newPerformance);
		else{
			newPerformance.setPrev(cursor);
			newPerformance.setNext(cursor.getNext());
			cursor.getNext().setPrev(newPerformance);
			cursor.setNext(newPerformance);
			cursor = newPerformance;
			if(cursor.getNext() == null)
				tail = cursor;
		}
	}
	/**
	 * Removes the current node from the linked list.
	 * <dt><b>Precondition:</b><dd> This PerformanceList object has been initialized. The list is not empty.
	 * <dt><b>Postcondition:</b><dd> The node has been removed. The head, tail and cursor nodes have been updated as needed.
	 * @return a boolean value based on whether or not the node was removed.
	 * @throws EmptyListException: Indicates that the list is empty.
	 */
	public boolean removeCurrentNode() throws EmptyListException{ 
		if(head == null){
			throw new EmptyListException();
		}
		else if(head != null && head == tail && cursor == head){
			head = null;
			cursor = null;
			tail = null;
			return true;
		}
		else if(cursor == tail){
			cursor = cursor.getPrev();
			cursor.setNext(null);
			tail = cursor;
			return true;
		}
		else if(cursor == head){
			cursor = cursor.getNext();
			cursor.setPrev(null);
			head = cursor;
			return true;
		}
		else{
			cursor.getPrev().setNext(cursor.getNext());
			cursor.getNext().setPrev(cursor.getPrev());
			cursor = cursor.getNext();
			return true;
		}
	}
	/**
	 * Displays the current performance node in the linked list.
	 * <dt><b>Precondition:</b><dd> This PerformanceList object has been initialized. The list is not empty.
	 * @throws EmptyListException: Indicates the list is empty.
	 */
	public void displayCurrentPerformance() throws EmptyListException{
		if(cursor == null)
			throw new EmptyListException();
		else
			System.out.println(cursor.toString());
	}
	/**
	 * Moves the cursor node forward one node.
	 * <dt><b>Precondition:</b><dd> This PerformanceList object has been initialized. The list is not empty.
	 * <dt><b>Postcondition:</b><dd> The cursor node has been moved a node forward.
	 * @return a boolean value based on whether or not the cursor node moved.
	 * @throws EmptyListException: Indicates that the list is empty.
	 * @throws NullPointerException: Indicates that the cursor node is at the end of the linked list.
	 */
	public boolean moveCursorForward() throws EmptyListException, NullPointerException{ 
		if(cursor == null){
			throw new EmptyListException();
		}
		else if(cursor.getNext() == null)
			throw new NullPointerException();
		else{
			cursor = cursor.getNext();
			return true;
		}
	}
	/**
	 * Moves the cursor node backward one node.
	 * <dt><b>Precondition:</b><dd> This PerformanceList object has been initialized. The list is not empty.
	 * <dt><b>Postcondition:</b><dd> The cursor node has been moved a node backward.
	 * @return a boolean value based on whether or not the cursor node moved.
	 * @throws EmptyListException: Indicates that the list is empty.
	 * @throws NullPointerException: Indicates that the cursor node is at the beginning of the linked list.
	 */
	public boolean moveCursorBackward() throws EmptyListException, NullPointerException{
		if(cursor == null){
			throw new EmptyListException();
		}
		else if(cursor.getPrev() == null)
			throw new NullPointerException();
		else{
			cursor = cursor.getPrev();
			return true;
		}
	}
	/**
	 * Changes the position of the cursor to another position in the linked list.
	 * @param position: the desired position to move to.
	 * <dt><b>Precondition:</b><dd> This PerformanceList object has been initialized. The list is not empty. The position >= 0 and position < listSize.
	 * <dt><b>Postcondition:</b><dd> The cursor node has been moved to the desired position.
	 * @return verdict: a boolean value based on whether or not the cursor moved.
	 * @throws NullPointerException: Indicates that the position value is either negative or beyond the list size.
	 */
	public boolean jumpToPosition(int position) throws NullPointerException{
		PerformanceNode temp = head;
		boolean verdict = false;
		if(position < 0)
			throw new NullPointerException();
		for(int i = 0; i < position; i++){
			if(temp == null)
				throw new NullPointerException();
			else if(i == position - 1){
				cursor = temp;
				verdict = true;
			}
			else
				temp = temp.getNext();
		}
		return verdict;
	}
	/**
	 * Displays a nicely formatted table of the data of all of the nodes in the linked list.
	 * <dt><b>Precondition:</b><dd> This PerformanceList object has been initialized.
	 * @return a string value of the data to be displayed.
	 */
	public String toString(){
		System.out.println("Current No. Performance Name           Lead Performer Name      Participants Duration Start Time\n"
				+ "------------------------------------------------------------------------------------------------");
		PerformanceNode temp = head;
		int index = 1;
		while(temp != null){
			if(temp == cursor)
				System.out.print("      *   " + index + " ");
			else
				System.out.print("          " + index + " ");
			System.out.println(temp.toString());
			temp = temp.getNext();
			index++;
		}
		return "";
	}
	/**
	 * Updates the start time of all of the nodes in the linked list.
	 * <dt><b>Precondition:</b><dd> This PerformanceList object has been initialized.
	 * <dt><b>Postcondition:</b><dd> The start time of all of the performance nodes has been updated.
	 */
	public void updateStartTime(){
		PerformanceNode temp = head;
		while(temp != null){
			temp.setStartTime();
			temp = temp.getNext();
		}
	}
}
