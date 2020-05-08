import java.util.Arrays;
import java.util.Comparator;

import edu.princeton.cs.algs4.In;

public class Term implements Comparable<Term> {

	private final String query;
	private final double weight;
	
    // Initialize a term with the given query string and weight.
    public Term(String query, double weight) {
    	if (query == null) throw new NullPointerException("Query must not be null");
    	if (weight < 0) throw new IllegalArgumentException("Weight must be nonnegative");
    	this.query = query;
    	this.weight = weight;
    }

    // Compare the terms in descending order by weight.
    public static class byReverseWeightOrder implements Comparator<Term> {
    	@Override
    	public int compare(Term v, Term w) {
    		return -Double.compare(v.weight, w.weight);
    	}
    }

    // Compare the terms in lexicographic order but using only the first r characters of each query.
    public static class byPrefixOrder implements Comparator<Term> {
    	private int r;
		public byPrefixOrder(int r) {
    		if (r < 0) throw new IllegalArgumentException("r must be nonnegative");
    		this.r= r;
    	}
		@Override
		public int compare(Term v, Term w) {
			
			String tq1;
			String tq2;
			
			// we first check whether our terms to compare are shorter than r
			// if they are compare full term, otherwise compare part
			if (r >= v.query.length()) tq1 = v.query;
			else tq1 = v.query.substring(0,r);
			//
			if (r >= w.query.length()) tq2 = w.query;
			else tq2 = w.query.substring(0,r);
			// this is needed to prevent exceptions from call to substring
			
			return tq1.compareTo(tq2);
		}
    } 

    // Compare the terms in lexicographic order by query.
    @Override
    public int compareTo(Term that) {
    	return this.query.compareTo(that.query);
    }

    // Return a string representation of the term in the following format:
    // the weight, followed by a tab, followed by the query.
    @Override
    public String toString() {
    	return String.format("%12.2f\t%s", this.weight, this.query);
    }
    
    /**
     * for testing
     * 
     * @param args
     */
    public static void main(String[] args) {
    	String filename = args[0];
        Term[] terms = populateTerms(filename);
        
        Arrays.sort(terms);
        printTerms(terms);
        
        Comparator<Term> rwo = new byReverseWeightOrder();
        Comparator<Term> po0 = new byPrefixOrder(0);
        Comparator<Term> po1 = new byPrefixOrder(1);
        Comparator<Term> po2 = new byPrefixOrder(2);
        Comparator<Term> po4 = new byPrefixOrder(4);
        
        System.out.println("\nbyReverseWeightOrder");
        Arrays.sort(terms, rwo);
        printTerms(terms);
        
        System.out.println("\nbyPrefixOrder(0)");
        Arrays.sort(terms, po0);
        printTerms(terms);
        
        System.out.println("\nbyPrefixOrder(1)");
        Arrays.sort(terms, po1);
        printTerms(terms);
        
        System.out.println("\nbyPrefixOrder(2)");
        Arrays.sort(terms, po2);
        printTerms(terms);
        
        System.out.println("\nbyPrefixOrder(4)");
        Arrays.sort(terms, po4);
        printTerms(terms);

    }

	private static Term[] populateTerms(String filename) {
        In in = new In(filename);
        int N = in.readInt();
        Term[] terms = new Term[N];
        for (int i = 0; i < N; i++) {
            double weight = in.readDouble();       // read the next weight
            in.readChar();                         // scan past the tab
            String query = in.readLine();          // read the next query
            terms[i] = new Term(query.trim(), weight);    // construct the term
        }
		return terms;
	}
    
    private static void printTerms(Term[] terms) {
        for (Term t : terms)
        	System.out.println(t);
    }
    
}