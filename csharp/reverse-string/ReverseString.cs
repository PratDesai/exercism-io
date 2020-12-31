using System.Linq;

public static class ReverseString
{
    public static string Reverse(string input)
    {
        // return string.Concat(input.Reverse());
        return input.Select(x => $"{x}").Aggregate("", (acc, s) => s + acc);
    }
}