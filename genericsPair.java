/*
���������� generic-����� Pair, ������� �� Optional, �� ���������� ���� ��������� ������ ����� � �� ����������� ��������� ��������� �������� null.

���������� ������ getFirst(), getSecond(), equals() � hashCode(), � ����� ����������� ��������� ����� of(). ����������� ������ ���� �������� (private).

� ��������� ������������� ������� Pair ������ ��������������� � ������� �������� ��������� ���:

Pair<Integer, String> pair = Pair.of(1, "hello");
Integer i = pair.getFirst(); // 1
String s = pair.getSecond(); // "hello"

Pair<Integer, String> pair2 = Pair.of(1, "hello");
boolean mustBeTrue = pair.equals(pair2); // true!
boolean mustAlsoBeTrue = pair.hashCode() == pair2.hashCode(); // true!


����������, �� ������� ����������� ������� ������ Pair. ��� ���������� �������� ����� ������ ����� �������� ���������.
*/

class Pair<A, B> {
    private A first;
    private B second;

    public Pair(A first, B second) {
    	super();
    	this.first = first;
    	this.second = second;
    }

    public int hashCode() {
    	int hashFirst = first != null ? first.hashCode() : 0;
    	int hashSecond = second != null ? second.hashCode() : 0;

    	return (hashFirst + hashSecond) * hashSecond + hashFirst;
    }

    public boolean equals(Object other) {
    	if (other instanceof Pair) {
    		Pair otherPair = (Pair) other;
    		return 
    		((  this.first == otherPair.first ||
    			( this.first != null && otherPair.first != null &&
    			  this.first.equals(otherPair.first))) &&
    		 (	this.second == otherPair.second ||
    			( this.second != null && otherPair.second != null &&
    			  this.second.equals(otherPair.second))) );
    	}

    	return false;
    }

    public A getFirst() {
    	return first;
    }

    public B getSecond() {
    	return second;
    }
    
    public static <A, B> Pair<A, B> of(A first, B second) {
        return new Pair<A, B>(first, second);
    }

}