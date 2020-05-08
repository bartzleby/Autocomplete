import java.util.Arrays;
import java.util.Comparator;

public class Autocomplete {
	
	private final Term[] terms;

    // Initialize the data structure from the given array of terms.
    public Autocomplete(Term[] terms) {
    	
    	if (terms == null) throw new NullPointerException();
    	
    	this.terms = terms;
    	Arrays.sort(this.terms);
    }

    // Return all terms that start with the given prefix, in descending order of weight.
    public Term[] allMatches(String prefix) {
    	
    	if (prefix == null) throw new NullPointerException();
    	
    	Term preTerm = new Term(prefix, 0);
    	Comparator<Term> poc = new Term.byPrefixOrder(prefix.length());
    	int i = BinarySearchDeluxe.firstIndexOf(terms, preTerm, poc);
    	
    	if (i == -1) return new Term[0];
    	
    	int j = BinarySearchDeluxe.lastIndexOf(terms, preTerm, poc);
    	
    	Term[] matches = new Term[j-i+1];
    	for (int t = 0; t < matches.length; t++) {
    		matches[t] = terms[i++];
    	}
    	
    	Comparator<Term> woc = new Term.byReverseWeightOrder();
    	Arrays.sort(matches, woc);
    	
    	return matches;
    }

    // Return the number of terms that start with the given prefix.
    public int numberOfMatches(String prefix) {
    	
    	if (prefix == null) throw new NullPointerException();
    	
    	Term preTerm = new Term(prefix, 0);
    	Comparator<Term> poc = new Term.byPrefixOrder(prefix.length());
    	int i = BinarySearchDeluxe.firstIndexOf(terms, preTerm, poc);
    	
    	if (i == -1) return 0;
    	
    	int j = BinarySearchDeluxe.lastIndexOf(terms, preTerm, poc);
    	
    	return j-i+1;
    }
}