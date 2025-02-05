class Video {
    private String title;
    private boolean checkedOut;
    private double averageRating;
    private int ratingCount;
    private int totalRating;

    public Video(String title) {
        this.title = title;
        this.checkedOut = false;
        this.averageRating = 0.0;
        this.ratingCount = 0;
        this.totalRating = 0;
    }

    public void checkOut() {
        checkedOut = true;
    }

    public void returnVideo() {
        checkedOut = false;
    }

    public void receiveRating(int rating) {
        totalRating += rating;
        ratingCount++;
        averageRating = (double) totalRating / ratingCount;
    }

    public String getTitle() {
        return title;
    }

    public boolean isCheckedOut() {
        return checkedOut;
    }

    public double getAverageRating() {
        return averageRating;
    }

    @Override
    public String toString() {
        return "Title: " + title + ", Checked Out: " + checkedOut + ", Average Rating: " + averageRating;
    }
}

class VideoStore {
    private Video[] videos;
    private int count;

    public VideoStore() {
        videos = new Video[10];
        count = 0;
    }

    public void addVideo(String title) {
        if (count < videos.length) {
            videos[count++] = new Video(title);
        }
    }

    public void checkOut(String title) {
        for (int i = 0; i < count; i++) {
            if (videos[i].getTitle().equals(title)) {
                videos[i].checkOut();
                break;
            }
        }
    }

    public void returnVideo(String title) {
        for (int i = 0; i < count; i++) {
            if (videos[i].getTitle().equals(title)) {
                videos[i].returnVideo();
                break;
            }
        }
    }

    public void receiveRating(String title, int rating) {
        for (int i = 0; i < count; i++) {
            if (videos[i].getTitle().equals(title)) {
                videos[i].receiveRating(rating);
                break;
            }
        }
    }

    public void listInventory() {
        for (int i = 0; i < count; i++) {
            System.out.println(videos[i]);
        }
    }
}

public class VideoStoreLauncher {
    public static void main(String[] args) {
        VideoStore store = new VideoStore();
        
        store.addVideo("Sholay");
        store.addVideo("Baahubali");
        store.addVideo("RRR");
        
        store.receiveRating("Sholay", 5);
        store.receiveRating("Sholay", 4);
        store.receiveRating("Baahubali", 5);
        store.receiveRating("Baahubali", 3);
        store.receiveRating("RRR", 4);
        store.receiveRating("RRR", 5);
        
        store.checkOut("Sholay");
        store.checkOut("Baahubali");
        store.checkOut("RRR");
        
        store.returnVideo("Sholay");
        store.returnVideo("RRR");
        
        System.out.println("Inventory after 'Baahubali' has been rented out:");
        store.listInventory();
    }
}
