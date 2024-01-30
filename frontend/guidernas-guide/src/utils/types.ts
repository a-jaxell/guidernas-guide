import { DateTime } from "luxon";

export interface Activity {
    id: number | null;
    title: string;
    status: ActivityStatus;
    description: string;
    type: ActivityType | null;
    format: ActivityFormat | null;
    startTime: Date | null | string;
    endTime: Date | null | string;
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
export enum ActivityStatus {
    IDLE="Idle",
    STARTED="Started",
    FINISHED="Finished",
    VOID="Void"
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