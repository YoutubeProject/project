package youtubeProject.program;

import youtubeProject.channels.OneChannel;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class Channel {
    private final SimpleStringProperty channelName;
    private final SimpleStringProperty dateOfCreation;
    private final SimpleIntegerProperty numberOfSubscribers;
    private final SimpleIntegerProperty numberOfVideos;
    private final SimpleIntegerProperty numberOfViews;


    public Channel(OneChannel oneChannel) {
        this.channelName = new SimpleStringProperty(oneChannel.snippet.title);
        this.dateOfCreation = new SimpleStringProperty(oneChannel.snippet.publishedAt);
        this.numberOfSubscribers = new SimpleIntegerProperty(oneChannel.statistics.subscriberCount);
        this.numberOfVideos = new SimpleIntegerProperty(oneChannel.statistics.videoCount);
        this.numberOfViews = new SimpleIntegerProperty(oneChannel.statistics.viewCount);
    }

    public String getChannelName() {
        return channelName.get();
    }

    public String getDateOfCreation() {
        return dateOfCreation.get();
    }

    public int getNumberOfSubscribers() {
        return numberOfSubscribers.get();
    }

    public int getNumberOfVideos() {
        return numberOfVideos.get();
    }

    public int getNumberOfViews() {
        return numberOfViews.get();
    }

    public void setChannelName(String channelName) {
        this.channelName.set(channelName);
    }

    public void setDateOfCreation(String dateOfCreation) {
        this.dateOfCreation.set(dateOfCreation);
    }

    public void setNumberOfSubscribers(int numberOfSubscribers) {
        this.numberOfSubscribers.set(numberOfSubscribers);
    }

    public void setNumberOfVideos(int numberOfVideos) {
        this.numberOfVideos.set(numberOfVideos);
    }

    public void setNumberOfViews(int numberOfViews) {
        this.numberOfViews.set(numberOfViews);
    }
}
