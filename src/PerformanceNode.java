/**
*Yassine Khaliqui
*109050245
*Homework Assignment Number 2
*CSE 214 Recitation Section 06
*Recitation TA: Kevin Flyangolts 
*Grading TA: Zheyuan (Jeffrey) Gao;
*@author Yassine
*/
public class PerformanceNode {

	private String name;
	private String leadPerformer;
	private int attendance;
	private int duration;
	private int startTime;
	private PerformanceNode next;
	private PerformanceNode prev;
	/**
	 * Creates a new PerformanceNode object with blank parameters.
	 */
	PerformanceNode(){}
	/**
	 * Creates a new Performance object with given parameters.
	 * @param name: name of the performance.
	 * @param leadPerformer: the lead performer.
	 * @param attendance: the number attending.
	 * @param duration: how long the performance lasts.
	 */
	PerformanceNode(String name, String leadPerformer, int attendance, int duration){
		this.name = name;
		this.leadPerformer = leadPerformer;
		this.attendance = attendance;
		this.duration = duration;
		this.startTime = 0;
		next = null;
		prev = null;
	}
	/**
	 * Returns the name of the performance.
	 * @return the name as a String.
	 */
	public String getName(){
		return name;
	}
	/**
	 * Returns the lead performer of the performance.
	 * @return the lead performer as a String.
	 */
	public String getLeadPerformer(){
		return leadPerformer;
	}
	/**
	 * Returns the attendance of the performance.
	 * @return the attendance as an int.
	 */
	public int getAttendance(){
		return attendance;
	}
	/**
	 * Returns the duration of the performance.
	 * @return the duration as an int.
	 */
	public int getDuration(){
		return duration;
	}
	/**
	 * Returns the start time of the performance.
	 * @return the start time as an int.
	 */
	public int getStartTime(){
		return startTime;
	}
	/**
	 * Changes the name value of a particular PerformanceNode.
	 * @param name: the new name of the PerformanceNode.
	 */
	public void setName(String name){
		this.name = name;
	}
	/**
	 * Changes the lead performer value of a particular PerformanceNode.
	 * @param leadPerformer: the new lead performer of the PerformanceNode.
	 */
	public void setLeadPerformer(String leadPerformer){
		this.leadPerformer = leadPerformer;
	}
	/**
	 * Changes the attendance value of a particular PerformanceNode.
	 * @param attendance: the new attendance of the PerformanceNode.
	 */
	public void setAttendance(int attendance){
		this.attendance = attendance;
	}
	/**
	 * Changes the duration value of a particular PerformanceNode.
	 * @param duration: the new duration of the PerformanceNode.
	 */
	public void setDuration(int duration){
		this.duration = duration;
	}
	/**
	 * Changes the start time value of a particular PerformanceNode.
	 * @param startTime: the new start time of the PerformanceNode.
	 */
	public void setStartTime(int startTime){
		this.startTime = startTime;
	}
	/**
	 * Updates the start time of a particular PerformanceNode based on the previous node.
	 */
	public void setStartTime(){
		if(getPrev() == null)
			this.startTime = 0;
		else
			this.startTime = getPrev().getDuration() + getPrev().getStartTime();
	}
	/**
	 * Returns the next performance node of the performance.
	 * @return the next performance as a PerformanceNode.
	 */
	public PerformanceNode getNext(){
		return next;
	}
	/**
	 * Returns the previous performance node of the performance.
	 * @return the previous performance as an PerformanceNode.
	 */
	public PerformanceNode getPrev(){
		return prev;
	}
	/**
	 * Sets the performance node that will come after the current performance node.
	 * @param node: the node that will be set as the next node in the list.
	 */
	public void setNext(PerformanceNode node){
		next = node;
	}
	/**
	 * Sets the performance node that will come before the current performance node.
	 * @param node: the node that will be set as the previous node in the list.
	 */
	public void setPrev(PerformanceNode node){
		prev = node;
	}
	/**
	 * Returns the data of a particular PerformanceNode, formatted.
	 * @return formatted: the formatted String representation of the node.
	 */
	public String toString(){
		String formatted = String.format("%-27s%-25s%-13d%-9d%-2d", getName(), getLeadPerformer(), getAttendance(), getDuration(), getStartTime());
		return formatted;
	}
}
