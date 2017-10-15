package youtubeProject.program;

import youtubeProject.channels.ChannelListResponse;
import youtubeProject.channels.OneChannel;
import youtubeProject.channels.Request1;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mashape.unirest.http.exceptions.UnirestException;
import javafx.scene.text.Text;
import youtubeProject.interfase.userInterfase.settingsInterfase.SaveToCache;

import java.util.Scanner;


import java.io.*;

import static youtubeProject.program.Settings.*;

public class RequestOne {
    Text name;
    Text description;
    public static String channelId = "UCJALCpMORvQrlN7dAPLiCWg";

    public RequestOne(String channelId ){
        this.channelId = channelId;
    }
    public RequestOne(){
        this.channelId = channelId;
    }


}
