'use client'
import { Activity, ActivityFormat, ActivityType } from '@/utils/types';
import React, { useEffect, useState } from 'react'

const ActivityForm = ({initialData}: {initialData: Activity}) => {
  const [isEditMode, setIsEditMode] = useState(false);

  useEffect(() => {
      setIsEditMode(Boolean(initialData && initialData.id));
  }, [initialData]);
  
  const handleSubmit = (event: React.FormEvent) => {
    event.preventDefault();
    // TODO: Use a state/store manager to set these in the state and then submit that object on submit
    const formData = new FormData(event.target as HTMLFormElement);
    const data = Object.fromEntries(formData.entries());
    console.log(data);

    };

  return (

    <div className='w-4/5 h-40'>
      <h1>Create new Activity</h1>
        <form className='form-control' onSubmit={handleSubmit}>
            <input name="title" maxLength={255} defaultValue={initialData.title || ""} className='input input-lg input-primary w-full max-w-xs' type="text" placeholder='Enter an title'/>
            <input name='description' maxLength={255} defaultValue={initialData.description || ""} className='textarea textarea-lg textarea-bordered w-full max-w-xs h-40' type="textarea" placeholder='Enter an Description' />
              <select name='type' defaultValue={initialData.type || "Pick an activity type"} className='select select-md select-primary w-full max-w-xs'>
                {/* These options should be fetched as Enums */}
                <option disabled>Pick an activity type</option>
                <option>Skiing</option>
                <option>Hiking</option>
                <option>Climbing</option>
                <option>Kayaking</option>
              </select>
              <select name='format'defaultValue={initialData.format || "Pick an activity format"} className='select select-md select-primary w-full max-w-xs'>
                {/* These options should be fetched as enums */}
                <option disabled>Pick an activity format</option>
                <option>Expedition</option>
                <option>Daytrip</option>
                <option>Seminar</option>
                <option>Class</option>
              </select>
              {/* datepicker here https://ui.shadcn.com/docs/components/date-picker */}
              <input className='btn btn-secondary w-full max-w-xs' type="submit"/>
        </form>
    </div>
  )
}

export default ActivityForm;