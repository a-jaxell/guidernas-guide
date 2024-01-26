'use client'
import React, { useState } from 'react'
import { DateTime } from 'luxon'

const DateSelector = () => {
    // This is meant to be a part of a form that will pass value to the parent component
    const [startDate, setStartDate] = useState(DateTime.now().toLocaleString())
    const [endDate, setEndDate] = useState(DateTime.now().toLocaleString())
    const dateRange = {
        startTime: startDate,
        endTime: endDate,
    }

    return (
        <div className="flex flex-row w-full justify-evenly p-5">
            <input
                name="startTime"
                className="h-8 text-center pr-2 rounded-md"
                type="date"
                onChange={(e) => setStartDate(e.target.value)}
                value={startDate.toLocaleString()}
            />
            <input
                name="endTime"
                className="h-8 text-center pr-2 rounded-md"
                type="date"
                onChange={(e) => setEndDate(e.target.value)}
                value={endDate.toLocaleString()}
            />
        </div>
    )
}
export default DateSelector
