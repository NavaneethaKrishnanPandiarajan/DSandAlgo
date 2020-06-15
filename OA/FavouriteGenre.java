//$Id$
package AM;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
	Given a map Map<String, List<String>> userSongs with user names as keys and a list of all the songs that the user has listened to as values.

	Also given a map Map<String, List<String>> songGenres, with song genre as keys and a list of all the songs within that genre as values. 
	
	The song can only belong to only one genre.

	The task is to return a map Map<String, List<String>>, 

	where the key is a user name and the value is a list of the user's favorite genre(s). 
	
	Favorite genre is the most listened to genre. A user can have more than one favorite genre if he/she has listened to the same number of songs per each of the genres.
 
 	Input:
	
	userSongs = 
	{  
   		"David": ["song1", "song2", "song3", "song4", "song8"],
   		"Emma":  ["song5", "song6", "song7"]
   	},

   songGenres = 
   {  
   		"Rock":    ["song1", "song3"],
   		"Dubstep": ["song7"],
   		"Techno":  ["song2", "song4"],
   		"Pop":     ["song5", "song6"],
   		"Jazz":    ["song8", "song9"]
	}

	Output: 
	{  
   		"David": ["Rock", "Techno"],
   		"Emma":  ["Pop"]
	}

Explanation:
		David has 2 Rock, 2 Techno and 1 Jazz song. So he has 2 favorite genres.
		Emma has 2 Pop and 1 Dubstep song. Pop is Emma's favorite genre.

 * 
 * 
 *
 */


public class FavouriteGenre 
{

	public Map<String, List<String>> getFovouriteMap (Map<String, List<String>> userSongs, Map<String, List<String>> songGeners) 
	{

		Map<String,String> songVsGenreMap = new HashMap<String,String>();
		
		for(Map.Entry<String, List<String>> entry : songGeners.entrySet()) 
		{
			String key = entry.getKey();
			entry.getValue().forEach( x ->  songVsGenreMap.put(x, key));
		}
		
		
		Map<String, List<String>> output = new HashMap<>();

		for(Map.Entry<String, List<String>> entry : userSongs.entrySet()) 
		{
			List<String> songs = entry.getValue();
			List<String> generes = new ArrayList<>();
			Map<String, Integer> genereFreq = new HashMap<>();

			for(String song : songs) 
			{
				//String genere = getGenereForSong(song, songGeners);  // it will leads to worst complexity , we should have a mapping for song vs genre map
				
				String genere = songVsGenreMap.get(song); 
				
				genereFreq.put(genere, genereFreq.getOrDefault(genere, 0)+1);
			}

			for(Map.Entry<String, Integer> e : genereFreq.entrySet()) 
			{

				if(e.getValue() > 1) 
				{
					generes.add(e.getKey());
				}
			}

			output.put(entry.getKey(), generes);
		}

		return output;

	}

	
	
	public String getGenereForSong(String song, Map<String, List<String>> songGeners) 
	{

	    for(Map.Entry<String, List<String>> entry : songGeners.entrySet()) {

	        if(entry.getValue().contains(song)) 
	        {
	            return entry.getKey();
	        }
	    }

	    return null;
	}
	
	
	public static void main(String args[]) 
	{
		FavouriteGenre f = new FavouriteGenre();
		Map<String, List<String>> userSongs = new HashMap<>();

		userSongs.put("David", Arrays.asList("song1", "song2", "song3", "song4", "song8"));
		userSongs.put("Emma", Arrays.asList("song5", "song6", "song7"));

		Map<String, List<String>> songGeners = new HashMap<>();
		songGeners.put("Rock", Arrays.asList("song1", "song3"));
		songGeners.put("Dubstep", Arrays.asList("song7"));
		songGeners.put("Techno", Arrays.asList("song2", "song4"));
		songGeners.put("Pop", Arrays.asList("song5", "song6"));
		songGeners.put("Jazz", Arrays.asList("song8", "song9"));

		Map<String, List<String>> favouriteMap = f.getFovouriteMap(userSongs, songGeners);

		System.out.println(favouriteMap);
	}
}
