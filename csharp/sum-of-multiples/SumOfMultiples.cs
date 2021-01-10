using System;
using System.Collections.Generic;
using System.Linq;

public static class SumOfMultiples
{
    public static int Sum(IEnumerable<int> multiples, int max)
    {
        var isMultiple = IsMultiple(multiples.Where(x => x > 0));
        return Enumerable.Range(0, max).Where(x => isMultiple(x)).Sum();
    }

    private static Func<int, bool> IsMultiple(IEnumerable<int> multiples)
    {
        return num => multiples.Any(mult => num % mult == 0);
    }
}