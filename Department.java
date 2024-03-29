package calhacks;

import java.net.URL;
import java.net.URLConnection;
import java.util.*; 
import java.io.IOException;

public class Department {
	/** Name of department. */
	public String _name;

	public ArrayList<ArrayList<String>> courses;
	protected HashMap<String, Course> _courseMap;
	
	public Department(String name, HashMap<String, Course> courseMap) {
	    _name = name;
	    _courseMap = courseMap;
	}

	public Department(String name) throws IOException {
		_name = name;
		String url = "http://guide.berkeley.edu/courses/" + name + "/";
        URL links = new URL(url);
        String input = DownloadPage.sourceCodeGen(links);
        courses = Parse.createArray(input);
	}

	public String toString() {
		return _name + " @ " + courses;
	}
}