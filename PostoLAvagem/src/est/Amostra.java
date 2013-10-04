package est;


public class Amostra {

	/**
	 * @uml.property  name="id"
	 */
	private int id;

	/**
	 * Getter of the property <tt>id</tt>
	 * @return  Returns the id.
	 * @uml.property  name="id"
	 */
	public int getId() {
		return id;
	}

	/**
	 * Setter of the property <tt>id</tt>
	 * @param id  The id to set.
	 * @uml.property  name="id"
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @uml.property  name="value"
	 */
	private int value;

	/**
	 * Getter of the property <tt>value</tt>
	 * @return  Returns the value.
	 * @uml.property  name="value"
	 */
	public int getValue() {
		return value;
	}

	/**
	 * Setter of the property <tt>value</tt>
	 * @param value  The value to set.
	 * @uml.property  name="value"
	 */
	public void setValue(int value) {
		this.value = value;
	}

		
		/**
		 */
		public Amostra(int id_p,int value_p){
			id = id_p;
			value = value_p;
		}

}
