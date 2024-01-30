'use server'
const API_BASE_URL = process.env.NEXT_PUBLIC_API_BASE_URL || 'http://springboot-api:8080/api';

// The following methods are meant to be used as shorthand for api requests to certain endpoints
export const getActivity = async (id: number)=> {
    const response = await fetch(`${API_BASE_URL}/activities/${id}`, {
        method: 'GET',
        headers: {
            'Content-Type': 'application/json',
        }
    });
    const data = await response.json();
    return data;

};
export const createActivity = async (activityData: any)=> {
    const response = await fetch(`${API_BASE_URL}/activities`, {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json',
        },
        body: JSON.stringify(activityData),
    });
    const data = await response.json();
    return data;

};
export const updateActivity = async (activityData: any)=> {
    const response = await fetch(`${API_BASE_URL}/activities(${activityData.id}`, {
        method: 'PUT',
        headers: {
            'Content-Type': 'application/json',
        },
        body: JSON.stringify(activityData),
    });
    const data = await response.json();
    return data;
};
