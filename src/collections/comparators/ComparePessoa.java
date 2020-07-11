package collections.comparators;

import java.util.Comparator;

public class ComparePessoa implements Comparator<Pessoa> {
    @Override
    public int compare(Pessoa p1, Pessoa p2) {
        return p1.getNome().compareTo(p2.getNome());
    }
}
