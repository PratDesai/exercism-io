using System.Collections.Generic;
using System.Linq;

public class HighScores
{
    private List<int> m_highScores;
    
    public HighScores(List<int> list)
    {
        m_highScores = list;
    }

    public List<int> Scores() => m_highScores;

    public int Latest() => m_highScores.Last();

    public int PersonalBest() => m_highScores.Max();

    public List<int> PersonalTopThree() => 
        m_highScores.OrderByDescending(x => x).Take(3).ToList();
}