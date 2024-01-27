import React from 'react'
import { DateTime } from 'luxon'
import useActivityStore from '@/context/useActivityStore'

const DateSelector = () => {
    // This is meant to be a part of a form that will pass value to the parent component

    const { formData, handleChange } = useActivityStore();

    return (
        <div className="w-full max-ws-xs p-5">
            <div className='label'>
                <span className='label-text'>Start date</span>
            </div>
            <input
                name="startTime"
                className="h-8 text-center pr-2 rounded-md"
                type="datetime-local"
                onChange={handleChange}
                value={formData.startTime || DateTime.now().toFormat('yyyy-MM-dd HH:mm')}
            />
            <div className='label'>
                <span className='label-text'>End date</span>
            </div>
            <input
                name="endTime"
                className="h-8 text-center pr-2 rounded-md"
                type="datetime-local"
                onChange={handleChange}
                value={formData.endTime || DateTime.now().toFormat('yyyy-MM-dd HH:mm')}
            />
        </div>
    )
}
export default DateSelector
