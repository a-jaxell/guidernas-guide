'use client'
import { createActivity, getActivity } from '@/utils/data';
import { Activity, ActivityFormat, ActivityType } from '@/utils/types';
import React, { useEffect, useState } from 'react'

const ActivityForm = ({ initialData = {
  title: '', description: '', type: '' as ActivityType, format: '' as ActivityFormat,
  id: 0,
  startTime: null,
  endTime: null,
  attendees: [],
  leaders: []
}}: {initialData: Activity}) => {
  const [isEditMode, setIsEditMode] = useState(false);
  const [req, setReq] = useState('')

  useEffect(() => {
      setIsEditMode(Boolean(initialData && initialData.id));
  }, [initialData]);
  
  const handleSubmit = async (event: React.FormEvent) => {
    event.preventDefault();
    // TODO: Use a state/store manager to set these in the state and then submit that object on submit
    // TODO: Add validation
    // TODO: Add error handling
    // TODO: Add API call to submit the data
    // TODO: Add success message
    const formData = new FormData(event.target as HTMLFormElement);
    const data = Object.fromEntries(formData.entries());
    
    await createActivity(data);

    };
    const handleRequest = async () => {
      
      const request = parseInt(req);
      const response = await getActivity(request);
    
      console.log(response);
    }

  return (

    <div className='w-4/5 h-40'>
      <h1>Create new Activity</h1>
        <form className='form-control' onSubmit={handleSubmit}>
            <input name="title" maxLength={255} defaultValue={initialData.title || ""} className='input input-lg input-primary w-full max-w-xs' type="text" placeholder='Enter an title'/>
            <input name='description' maxLength={255} defaultValue={initialData.description || ""} className='textarea textarea-lg textarea-bordered w-full max-w-xs h-40' type="textarea" placeholder='Enter an Description' />
              <select name='type' defaultValue={initialData.type || "Pick an activity type"} className='select select-md select-primary w-full max-w-xs'>
                <option disabled>Pick an activity type</option>
                {Object.values(ActivityType).map((type) => {
                  return <option key={type} value={type.toUpperCase()}>{type}</option>
                })}            
              </select>
              <select name='format'defaultValue={initialData.format || "Pick an activity format"} className='select select-md select-primary w-full max-w-xs'>
                <option disabled>Pick an activity format</option>
                {Object.values(ActivityFormat).map((format) => {
                  return <option key={format} value={format.toUpperCase()}>{format}</option>
                })}
              </select>
              {/* datepicker here https://ui.shadcn.com/docs/components/date-picker */}
              <input className='btn btn-secondary w-full max-w-xs' type="submit"/>
              <input onChange={e=> setReq(e.target.value)}type="text" name="id" defaultValue={initialData.id||""}/>
              <button className='btn btn-secondary w-full max-w-xs' type="button" onClick={()=>handleRequest()}>Get Activity</button>
        </form>
    </div>
  )
}

export default ActivityForm;