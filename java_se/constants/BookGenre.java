package constants;

/**
 * Enums are final, non-instantiable classes (all requirements are taken care of
 * by the compiler).
 */
public enum BookGenre {
	/*
	 * Constants within an enum are simply defined by naming them. Enums assign them
	 * a ordinal (similar to index), which can be used to compare the constants.
	 */
	MYSTERY, SCI_FI, ROMANCE, HISTORY, BIOGRAPHY
	// Ordinals assigned in order: 0, 1, 2, 3, 4. 
}
