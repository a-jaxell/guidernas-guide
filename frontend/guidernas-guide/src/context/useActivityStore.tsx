import { Activity, ActivityStatus } from '@/utils/types'
import { create } from 'zustand'

interface ActivityState {
    formData: Activity
    setFormData: (newFormData: Partial<Activity>) => void
    resetFormData: () => void
    handleChange: (event: React.ChangeEvent<HTMLInputElement | HTMLSelectElement | HTMLTextAreaElement>) => void 
}

//Matches the ActivityCreateDto in the backend
const useActivityStore = create<ActivityState>((set) => ({
    formData: {
        id: null,
        title: '',
        status: ActivityStatus.VOID,
        description: '',
        type: null,
        format: null,
        startTime: null,
        endTime: null,
        attendees: [],
        leaders: []
    },
    setFormData: (newFormData) =>
        set((state) => ({ formData: { ...state.formData, ...newFormData } })),
    handleChange: (event: React.ChangeEvent<HTMLInputElement | HTMLSelectElement | HTMLTextAreaElement>) => {
        const { name, value } = event.target;
        set((state) => ({ formData: { ...state.formData, [name]: value } 
        }))
    },
    resetFormData: () =>
        set({
            formData: {
                id: null,
                title: '',
                status: ActivityStatus.VOID,
                description: '',
                type: null,
                format: null,
                startTime: null,
                endTime: null,
                attendees: [],
                leaders: []
            },
        }),
}))
export default useActivityStore;
