
const API_BASE_URL = process.env.NEXT_PUBLIC_API_BASE_URL;

export const createActivity = async (activityData: any)=> {
    const response = await fetch(`${API_BASE_URL}/activities`, {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json',
        },
        body: JSON.stringify({activityData}),
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
        body: JSON.stringify({activityData}),
    });
    const data = await response.json();
    return data;
};