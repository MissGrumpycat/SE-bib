import java.io.*;

public class VerleihProtokollierer {
	
	
	/**
	 * Das Ereignis ist entweder Rückgabe oder Ausleihe
	 * 
	 * @require ereignis == "Ausleihe" || ereignis == "Rueckgabe"
	 * @require verleihkarte != null
	 * 
	 * @param ereignis Gibt an ob es sich um ausleihe oder rueckgabe handelt
	 * @param verleihkarte welche
	 */
	public static void protokolliere(String ereignis, Verleihkarte verleihkarte) throws ProtokollierException
	{
		assert ereignis.equals("Ausleihe") || ereignis.equals("Rueckgabe");
		assert verleihkarte != null;
		try (FileWriter protokoll = new FileWriter("./protokoll.txt",true))
		{
			if (ereignis.equals("Rueckgabe"))
			{
				protokoll.write(verleihkarte.getFormatiertenString() 
						+ "und Rücknahme am:" + Datum.heute() +"\n");
			}
			else
			{
				protokoll.write(verleihkarte.getFormatiertenString());
			}
		
		protokoll.write(ereignis);
		}
		catch (IOException e)
		{
			throw new ProtokollierException(e.toString());
		}
	}
}
