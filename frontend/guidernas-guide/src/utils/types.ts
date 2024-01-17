export interface Activity {
    id: number
    title: string;
    description: string;
    type: ActivityType;
    format: ActivityFormat;
    startTime: Date;
    endTime: Date;
    attendees: Customer[];
    leaders: Guide[];
}   

export enum ActivityType {
    SKIING= "Skiing",
    HIKING= "Hiking",
    KAYAKING= "Kayaking",
    CLIMBING= "Climbing"
}
export enum ActivityFormat {
    EXPEDITION= "Expedition",
    MULTIDAY= "Multiday",
    DAYTRIP= "Daytrip",
    HALFDAY= "Halfday",
    SEMINAR= "Seminar"
}

export interface User {
    userId: number;
    createdAt: Date;
}
export interface Professional extends User{

}
export interface Customer extends User{
    firstName: string;
    lastName: string;
    qualifications: string[];
    attendedActivities: Activity[];
}
export interface Guide extends Professional{
    firstName: string;
    lastName: string;
    qualifications: string[];
    assignedActivities: Activity[];
}
export interface Organization extends Professional{
    organizationName: string;
    descripton: string;
    associatedGuides: Guide[];
}