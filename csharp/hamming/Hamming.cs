using System;
using System.Collections;
using System.Collections.Generic;
using System.Linq;

public static class Hamming
{
    public static int Distance(string firstStrand, string secondStrand)
    {
        if (firstStrand.Count() != secondStrand.Count())
        {
            throw new ArgumentException();
        }
        var mismatchAccumulator = new MismatchAccumulator();
        firstStrand.SequenceEqual(secondStrand, mismatchAccumulator);
        return mismatchAccumulator.Count;
    }

    private class MismatchAccumulator : EqualityComparer<char>
    {
        public int Count { get; private set; }

        public override bool Equals(char x, char y)
        {
            if (!x.Equals(y))
            {
                Count++;
            }
            return true;
        }

        public override int GetHashCode(char obj) =>
            throw new NotImplementedException();
    }
}