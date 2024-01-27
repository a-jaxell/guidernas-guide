'use client'
import { createActivity, getActivity } from '@/actions/data'
import { Activity, ActivityFormat, ActivityStatus, ActivityType } from '@/utils/types'
import React, { useEffect, useState } from 'react'
import DateSelector from '../DateSelector/DateSelector'

const ActivityForm = (
        { initialData = 
            { 
                title: '',
                description: '', 
                type: '' as ActivityType, 
                format: '' as ActivityFormat,
                id: 0,
                startTime: null,
                endTime: null,
                attendees: [],
                leaders: [],
                status: ActivityStatus.IDLE
            }
        }: {initialData: Activity}
    ) => {
  const [isEditMode, setIsEditMode] = useState(false);
  const [req, setReq] = useState('')
  const [feedback, setFeedback] = useState({message: '', type:''})

    useEffect(() => {
        setIsEditMode(Boolean(initialData && initialData.id))
    }, [initialData])

    const handleSubmit = async (event: React.FormEvent) => {
        event.preventDefault()
        setFeedback({ message: '', type: '' })
        // TODO: Use a state/store manager to set these in the state and then submit that object on submit
        // TODO: Add validation
        // TODO: Add error handling
        // TODO: Add API call to submit the data
        // TODO: Add success message
        try {
            const formData = new FormData(event.target as HTMLFormElement)
            let data = Object.fromEntries(formData.entries())
            // Adds a initial status to Activity
            data = {...data, status: ActivityStatus.IDLE.toString()}
            const response = await createActivity(data)
            if (response.status !== 200) {
                setFeedback({
                    message: response.message || 'Something went wrong',
                    type: 'error',
                })
                console.log(response)
            } else {
                setFeedback({ message: response.message, type: 'success' })
            }
        } catch (error) {
            console.log(error)
        }
    }
    const handleRequest = async () => {
        setFeedback({ message: '', type: '' })
        try {
            const request = parseInt(req)
            const response = await getActivity(request)
            console.log(response)
        } catch (error) {
            setFeedback({ message: 'Something went wrong', type: 'error' })
            console.log(error)
        }
    }

    return (
        <div className="w-4/5 h-40">
            <form className="form-control flex flex-col gap-4 p-5" onSubmit={handleSubmit}>
            <h1 className="text-2xl w-full max-w-xs">Create new Activity</h1>
                <input
                    name="title"
                    required
                    maxLength={255}
                    defaultValue={initialData.title || ''}
                    className="input input-md input-primary w-full max-w-xs"
                    type="text"
                    placeholder="Enter an title"
                />
                <textarea
                    name="description"
                    required
                    maxLength={255}
                    defaultValue={initialData.description || ''}
                    className="textarea textarea-lg text-base textarea-bordered w-full max-w-xs h-40"
                    placeholder="Enter an Description"
                />
                <select
                    name="type"
                    defaultValue={initialData.type || 'Pick an activity type'}
                    className="select select-md select-primary w-full max-w-xs"
                >
                    <option disabled>Pick an activity type</option>
                    {Object.values(ActivityType).map((type) => {
                        return (
                            <option key={type} value={type.toUpperCase()}>
                                {type}
                            </option>
                        )
                    })}
                </select>
                <select
                    name="format"
                    defaultValue={
                        initialData.format || 'Pick an activity format'
                    }
                    className="select select-md select-primary w-full max-w-xs"
                >
                    <option disabled>Pick an activity format</option>
                    {Object.values(ActivityFormat).map((format) => {
                        return (
                            <option key={format} value={format.toUpperCase()}>
                                {format}
                            </option>
                        )
                    })}
                </select>
                <DateSelector />
                <input
                    className="btn btn-secondary w-full max-w-xs"
                    type="submit"
                />
                <input
                    className="input input-md input-primary w-full max-w-xs"
                    onChange={(e) => setReq(e.target.value)}
                    type="text"
                    name="id"
                    placeholder='Enter an ID'
                    defaultValue={initialData.id || ''}
                />
                <button
                    className="btn btn-secondary w-full max-w-xs"
                    type="button"
                    onClick={() => handleRequest()}
                >
                    Get Activity
                </button>
            </form>
            {feedback.message && (
                <div
                    role="alert"
                    className={
                        feedback.type === 'success'
                            ? 'max-w-xs alert alert-success'
                            : 'max-w-xs alert alert-error'
                    }
                >
                    {feedback.message}
                </div>
            )}
        </div>
    )
}

export default ActivityForm
