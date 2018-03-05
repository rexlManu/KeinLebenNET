package de.rexlmanu.bewerbung.config;
/*
* Class created by rexlManu
* Twitter: @rexlManu | Website: rexlManu.de
* Coded with IntelliJ
*/

import de.rexlmanu.bewerbung.Bewerbung;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;

public class ConfigHandler {

    private File file;
    private JSONObject jsonObject;

    private Bewerbung instance;

    public ConfigHandler() {
        this.instance = Bewerbung.getInstance();
        this.file = new File(instance.getDataFolder(), "config.json");
        if (!this.file.exists()) {
            this.jsonObject = new JSONObject();
            this.jsonObject.put("guiname", "&bTeleporter");
            this.jsonObject.put("itemname", "&aTeleporter");
            this.jsonObject.put("slot", 4);
            this.jsonObject.put("guiname", "&bTeleporter");
            write(file, jsonObject);
        }
        this.jsonObject = loadJsonObject();
    }

    public String getString(String key) {
        String s = (String) this.jsonObject.get(key);
        return s.replace("&", "§");
    }

    public String getInt(String key) {
        return (String) this.jsonObject.get(key);
    }

    public Object getObject(String key) {
        return this.jsonObject.get(key);
    }

    public JSONObject getJsonObject() {
        return jsonObject;
    }

    private void write(File file, JSONObject jsonObject) {
        try {
            FileWriter fileWriter = new FileWriter(file);
            fileWriter.write(jsonObject.toJSONString());
            fileWriter.flush();
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private JSONObject loadJsonObject() {
        try {
            return (JSONObject) new JSONParser().parse(new String(Files.readAllBytes(file.toPath())));
        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }
        return null;
    }
}
