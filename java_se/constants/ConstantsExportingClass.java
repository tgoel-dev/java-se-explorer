package constants;

/**
 * A constants exporting classes are typically used to define constants for the
 * entire project. It is more akin to a collection of data units.
 * 
 * Convention: constants exporting class(es) are stored in the "constants"
 * package.
 * 
 * (+) Allows centralized control of constants, and improved reusability.
 */
public class ConstantsExportingClass {

	// Movie Genres
	public static final int MOVIE_GENRE_THRILLER = 0;
	public static final int MOVIE_GENRE_HORROR = 1;
	public static final int MOVIE_GENRE_BIOGRPAPHY = 2;
	public static final int MOVIE_GENRE_HISTORIC = 3;

	// Book Genres
	public static final int BOOK_GENRE_MYSTERY = 4;
	public static final int BOOK_GENRE_SCI_FI = 5;
	public static final int BOOK_GENRE_ROMANCE = 7;

	/*
	 * (-) Constant exporting classes provide no type-safety security, and changes
	 * on the code require recompiling on the client-side. [Can be solved via OOP.]
	 * 
	 * (-) There is no namespace protection (each constant should be named different
	 * and cannot be grouped), resulting in long constant names; also does not allow
	 * for iterating over a group of constants. [Can be solved via better class
	 * design.]
	 * 
	 * OOP + Better class design: (-) Too cumbersome.
	 * Instead, use enums.
	 */
	
}
