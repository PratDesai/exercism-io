using System;
using System.Linq;

public static class Series
{
    public static string[] Slices(string numbers, int sliceLength)
    {
        if(sliceLength < 1 || sliceLength > numbers.Count())
            throw new ArgumentException(
                $"Length of {nameof(sliceLength)} cannot be less than 1" +
                $" or greater than length of {nameof(numbers)}.");

        var numOfSlices = numbers.Count() - (sliceLength - 1);
        var indexes = Enumerable.Range(0, numOfSlices);
        return indexes.Select(x => numbers.Substring(x, sliceLength)).ToArray();
    }
}