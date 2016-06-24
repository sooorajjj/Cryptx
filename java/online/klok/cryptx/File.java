package online.klok.cryptx;

/**
 * Created by klok on 17/6/16.
 */
public class File {
    private String title, message;
    private long fileId, dateCreatedMilli;
    private Category category;

    public enum Category{ PERSONAL, TECHNICAL, QUOTE, FINANCE }
    public File(String title, String message, Category category){
        this.title = title;
        this.message = message;
        this.category = category;
        this.fileId = 0;
        this.dateCreatedMilli = 0;
    }

    public File(String title, String message, Category category, long fileId, long dateCreatedMilli){
        this.title = title;
        this.message = message;
        this.category = category;
        this.fileId = fileId;
        this.dateCreatedMilli = dateCreatedMilli;
    }

    public String getTitle(){
        return title;
    }

    public String getMessage(){
        return message;
    }

    public Category getCategory(){
        return category;
    }

    public long getId(){
        return fileId;
    }

    public long getDate(){
        return dateCreatedMilli;
    }

    public String toString(){
        return "ID: " + fileId + " Title: " + title + " Message: " + message + " IconID: " + category.name()
                +" Date: ";

    }

    public int getAssociatedDrawable(){
        return categoryToDrawable(category);
    }

    public static int categoryToDrawable(Category fileCategory){
        switch(fileCategory){
            case PERSONAL:
                return R.drawable.p;
            case TECHNICAL:
                return R.drawable.t;
            case FINANCE:
                return R.drawable.f;
            case QUOTE:
                return R.drawable.q;
        }

        return R.drawable.p2;
    }

}
