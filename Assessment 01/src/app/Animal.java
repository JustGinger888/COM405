package app;

/**
 * Animal stores data of the occupant in the enclosure
 */
public class Animal 
{
    private String animalName;
    private String ownerName;
    private String animalAge;
    private String animalGender;
    private String animalBreed;
    private String generalNotes;
    private String bookingLength;

    public Animal(String animalNameIn, String ownerNameIn, String animalAgeIn, String animalGenderIn, String animalBreedIn, String generalNotesIn, String bookingLengthIn)
    {
        animalName = animalNameIn;
        ownerName = ownerNameIn;
        animalAge = animalAgeIn;
        animalGender = animalGenderIn;
        animalBreed = animalBreedIn;
        generalNotes = generalNotesIn;
        bookingLength = bookingLengthIn;
    }

    public String GetAnimalName()
    {
        return animalName;
    }

    public String GetOwnerName()
    {
        return ownerName;
    }

    public String GetAnimalAge()
    {
        return animalAge;
    }

    public String GetAnimalGender()
    {
        return animalGender;
    }

    public String GetAnimalBreed()
    {
        return animalBreed;
    }

    public String GetGeneralNotes()
    {
        return generalNotes;
    }

    public String GetBookingLength()
    {
        return bookingLength;
    }
}