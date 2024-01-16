export type Activity {
    title: string;
    description: string;
    type: ActivityType;
    format: ActivityFormat;
    startTime: Date;
    endTime: Date;
    attendees: Customer[];
    leaders: Guide[];
}   

enum ActivityType {
    SKIING= "Skiing",
    HIKING= "Hiking",
    KAYAKING= "Kayaking",
    CLIMBING= "Climbing"
}
enum ActivityFormat {
    EXPEDITION= "Expedition",
    MULTIDAY= "Multiday",
    DAYTRIP= "Daytrip",
    HALFDAY= "Halfday",
    SEMINAR= "Seminar"
}

interface User {
    userId: number;
    createdAt: Date;
}
interface Professional extends User{

}
interface Customer extends User{
    firstName: string;
    lastName: string;
    qualifications: string[];
    attendedActivities: Activity[];
}
interface Guide extends Professional{
    firstName: string;
    lastName: string;
    qualifications: string[];
    assignedActivities: Activity[];
}
interface Organization extends Professional{
    organizationName: string;
    descripton: string;
    associatedGuides: Guide[];
}
