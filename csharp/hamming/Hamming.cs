using System;
using System.Linq;

public static class Hamming
{
    public static int Distance(string firstStrand, string secondStrand)
    {
        if (firstStrand.Count() != secondStrand.Count())
            throw new ArgumentException("Strand length mismatch");

        return firstStrand.Select((x, idx) => x.Equals(secondStrand[idx]))
                          .Where(x => !x)
                          .Count();
    }
}