/**
 * Interface of a Set
 * 
 * @author Jeton Sinoimeri
 * 
 * @since Feb 1, 2014
 *
 */


public interface SetInterface <T>
{
	/**
	 * Adds a new entry to this set, avoiding duplicates.
	 * Increases the number of entries by 1.
	 * 
	 * @param newEntry  the object to be added as a new entry
	 * @return true, if the addition is successful, or 
	 * 		   false, if the item already is in the set
	 * 
	 */
	
	public boolean add(T newEntry);
	
	
	/**
	 * Removes a specific entry from this set.
	 * Decreases the number of entries by 1.
	 * 
	 * @param anEntry  the object to be removed
	 * @return true, if the removal was successful, or
	 *         false, if the removal was unsuccessful
	 * 
	 */
	
	public boolean remove(T anEntry);
	
	
	/**
	 * Removes an unspecified entry from this set.
	 * Decreases the number of entries by 1
	 * 
	 * @return either the entry if the removal was successful,
	 * 		   or, null
	 * 
	 */
	
	public T remove();
	
	
	/**
	 * Removes all entries from this set. 
	 * 
	 */
	
	public void clear();
	
	
	/**
	 * Tests whether this set contains a given entry.
	 * 
	 * @param anEntry  the object that is the desired entry
	 * @return true, if the set contains anEntry, or,
	 *         false, if the set does not
	 *         
	 */
	
	public boolean contains(T anEntry);
	
	
	/**
	 * Gets the size of this set.
	 * 
	 * @return the integer number of entries currently in the set
	 * 
	 */
	
	public int getCurrentSize();
	
	
	/**
	 * Sees whether this set is empty.
	 * 
	 * @return true, if the set is empty, or,
	 *         false, if the set is not
	 *         
	 */
	
	public boolean isEmpty();
	
	
	/**
	 * Sees whether this set is full.
	 * 
	 * @return true, if the set is full, or,
	 *         false, if the set is not
	 * 
	 */
	
	public boolean isFull();
	
	
	/**
	 * Retrieves all entries that are in this set.
	 * 
	 * @return newly allocated array of all entries in the set
	 * 
	 */
	
	public T[] toArray();
	
	
	/**
	 * Merges the current set with a second set.
	 * 
	 * @param anotherSet  the set to be merged with the current set
	 * @return union of the two sets
	 * 
	 */
	
	public SetInterface <T> union(SetInterface <T> anotherSet);
	
	
	/**
	 * Finds the intersection of the current set with a second set.
	 * 
	 * @param anotherSet  the set to intersect with the current set
	 * @return intersection of the two sets
	 * 
	 */
	
	public SetInterface <T> intersection(SetInterface <T> anotherSet);
	
	
	/**
	 * Performs a set difference.
	 * 
	 * @param anotherSet  the set to be subtracted from the current set
	 * @return current set minus anotherSet
	 * 
	 */
	
	public SetInterface <T> difference(SetInterface <T> anotherSet);

}
