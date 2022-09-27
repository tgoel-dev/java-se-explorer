package constants;

public enum MovieGenre {

	THRILLER(8), BIOGRAPHY(9), HORROR(15), HISTORIC(13), ADULT(18);
	// A ";" is needed at the end only if there is state/behavior in the enum.

	/*
	 * Enums can have state and behavior, as well as a pvt constructor. The pvt
	 * constructor is used by the constants to store a particular variable.
	 */
	
	private int ageRestriction;

	private MovieGenre(int ageRestriction) {
		this.ageRestriction = ageRestriction;
	}


	public int getAgeRestriction() {
		return this.ageRestriction;
	}

	/*
	 * Enums can also have constant-specific behavior, either via a switch
	 * statements (1) or by defining an abstract methods, which must be implemented
	 * by each constant via anonymous classes (2).
	 */
	public void behavior() {
		/*
		 * (1) (+) clean; (-) each constant requires a case. Thus, remember to add a
		 * case each time a new costant is added.
		 */
		switch (this) {
		case HORROR: // code
			break;
		case BIOGRAPHY: // code
			break;
		default: System.out.println("case unavailable");
			break;
		}
	}

	/*
	 * (2) (+) Ensures each constant implements the method. (-) cumbersome code.
	 */
	// public abstract void abstractBehavior();
}
