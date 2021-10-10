
class Location {
	private String desc;
	private String[] inputs;
  public boolean isEnd;


  public Location (String desc,  boolean isEnd){
    this.desc = desc;
    this.isEnd = isEnd;
  }
  public Location (String desc, String[] inputs){
    this.desc = desc;
	this.inputs = inputs;
    this.isEnd = false;
  }

	public boolean checkInput (String input){
		for (int i = 0; i < inputs.length; i++){
			if (input.equals(inputs[i])){
				return true;
			}
		}
		return false;
	}
	
  public String toString(){
    return "\n" + desc + " (" + String.join("/", inputs) + ") > ";
  }
}