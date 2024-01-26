'use client'
import React, { useState } from 'react'
import { DateTime } from 'luxon'
import { format } from 'path'
import { start } from 'repl'

const DateSelector = () => {
    // This is meant to be a part of a form that will pass value to the parent component
    const [startDate, setStartDate] = useState(DateTime.now().toISODate())
    const [endDate, setEndDate] = useState(DateTime.now().toISODate())

        // Create an object in the state that all these methods will pass data into
        // and then use that object in the parent component when making an api request
        // to the backend

        const formatDateTime = (date: string) => {
            return `${date}T03:00:00`; // Adds default time to date
        };    

    return (
        <div className="w-full max-ws-xs p-5">
            <div className='label'>
                <span className='label-text'>Start date</span>
            </div>
            <input
                name="startTime"
                className="h-8 text-center pr-2 rounded-md"
                type="date"
                onChange={(e) => setStartDate(e.target.value)}
                value={startDate}
            />
            <div className='label'>
                <span className='label-text'>End date</span>
            </div>
            <input
                name="endTime"
                className="h-8 text-center pr-2 rounded-md"
                type="date"
                onChange={(e) => setEndDate(e.target.value)}
                value={endDate}
            />
        </div>
    )
}
export default DateSelector
