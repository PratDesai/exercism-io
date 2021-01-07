using System;

public class SpaceAge
{
    private readonly Func<double, double> m_toPlanetYears;

    public SpaceAge(int seconds)
    {
        m_toPlanetYears = secondsPerYear => seconds / secondsPerYear;
    }

    public double OnEarth()
    {
        return m_toPlanetYears(31557600);
    }

    public double OnMercury()
    {
        return m_toPlanetYears(7600543.81992);
    }

    public double OnVenus()
    {
        return m_toPlanetYears(1.9414149052176E7);
    }

    public double OnMars()
    {
        return m_toPlanetYears(5.9354032690079994E7);
    }

    public double OnJupiter()
    {
        return m_toPlanetYears(3.74355659124E8);
    }

    public double OnSaturn()
    {
        return m_toPlanetYears(9.292923628848E8);
    }

    public double OnUranus()
    {
        return m_toPlanetYears(2.6513700193296E9);
    }

    public double OnNeptune()
    {
        return m_toPlanetYears(5.200418560032001E9);
    }
}