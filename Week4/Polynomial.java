import java.util.Scanner;
import java.util.Comparator;
import java.util.Iterator;

public class Polynomial implements Iterable<Polynomial.Term>, Comparable<Polynomial> {
    Comparator<Polynomial> compare;
    private Term head;

    public Polynomial(String fromFile) {
        head = null; 
        Scanner scan = new Scanner(fromFile);

        try {
            while (scan.hasNext()) {
                addTerm(scan.nextDouble(), scan.nextInt());
            }
        } catch (Exception ex) {
            System.out.println(ex.getLocalizedMessage());
            throw new InvalidPolynomialSyntax ("ERRR WRONG!\nPlease check syntax :)");
        }
    }

    public Term getHead() {
        return head;
    }


    public void addTerm(Double coefficient, int exp) {
        Term current = head;

        // Check for empty polynomial and address
        if (current == null) {
            head = new Term(coefficient, exp);
            head.next = null;
        } else { 
            while (current.next != null) {
                current = current.next;
            }
            current.next = new Term(coefficient, exp);
        }

    }

    @Override
    public int compareTo(Polynomial poly) {
        Term one = this.head;
        Term two = poly.head;

        while (one != null && two != null) {
            // check for positive
            if (one.getExponent() != two.getExponent()) {
                return one.getExponent() - two.getExponent();
            } else if (one.getCoefficient() != two.getCoefficient()) {
                return (two.getCoefficient() > one.getCoefficient()) ? -1 : +1 ;
            } 
            // reset the values
            one = one.getNext();
            two = two.getNext();
        } 
        //  check if both are null
        return (one == null && two == null) ? 0 : (one == null) ? -1 : 1;

    }

 
    public int compareExponents(Polynomial poly2) {
        Term one = this.head;
        Term two = poly2.head;

        while (one != null && two != null) {
            if (one.getExponent() != two.getExponent()) {
                return one.getExponent() - two.getExponent();
            } else {
                one = one.getNext();
                two = two.getNext();
            }
        }

        return (one == null && two == null) ? 0 : (two == null) ? +1 : -1;
    }

    public Polynomial() {
        compare = (Polynomial poly1, Polynomial poly2) -> poly1.compareExponents(poly2);
    }

    public Polynomial(Comparator<Polynomial> compare) {
        this.compare = compare;
    }

    
    @Override
    public Iterator<Term> iterator() {
        return new Iterator() {
            private Term current = getHead();
            @Override
            public boolean hasNext() {
                return current != null && current.getNext() != null;
            }
            @Override
            public Term next() {
                Term e = current;
                current = current.next;
                return e;
            }
        };
    }


    @Override
    public String toString() {
        StringBuilder expression = new StringBuilder();

        expression = (head.coefficient > 0) ? expression.append(head.toString()) : expression.append(" - ").append(head.toString());

        for (Term tmp = head.next; tmp != null; tmp = tmp.next) {
            expression = (tmp.coefficient < 0) ? expression.append(" - ").append(tmp.toString()) : expression.append(" + ").append(tmp.toString()); 
        }

        return expression.toString();
    }

    public static class Term {
        private Double coefficient;
        private int exponent;
        private Term next;

        public Term(Double coefficient, int exponent) {
            this.coefficient = coefficient;
            this.exponent = exponent;
            this.next = null; 
        }
        public int getExponent() {
            return exponent;
        }
        public Double getCoefficient() {
            return coefficient;
        }
        public Term getNext() {
            return next;
        }
        @Override
        public String toString() {
            String str = String.format("%.1f", Math.abs(coefficient));
            return (exponent == 0) ? String.format("(%s)", str) : (exponent == 1) ?  String.format("(%sx)", str) : String.format("(%sx^%d)", str, exponent);
        }

    }

}