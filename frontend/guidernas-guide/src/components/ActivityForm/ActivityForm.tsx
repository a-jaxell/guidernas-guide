'use client'
import React, { useState } from 'react'

const ActivityForm = () => {
  
  const [title, setTitle] = useState('Test');
  const [description, setDescription] = useState('A long journey');
  const [type, setType] = useState('Hiking');
  const [format, setFormat] = useState('Expedition');

  
  const handleSubmit = (event: React.FormEvent) => {
    // TODO: Use a state/store manager to set these in the state and then submit that object on submit
    const formData = new FormData(event.target);
    // TODO : decide wether to use HTML form handling or use state with store management
    event.preventDefault();
    console.log(formData);
    console.log({
      activity:{
        title: title,
        description: description,
        type: type,
        format: format
      }
    });
    setTitle('');
    setDescription('');
    setType('Pick an activity type');
    setFormat('Pick an activity format');
  }

  return (

    <div className='w-4/5 h-40'>
      <h1>Create new Activity</h1>
        <form className='form-control' onSubmit={handleSubmit}>
            <input onChange={(e)=> setTitle(e.target.value)} value={title} className='input input-lg input-primary w-full max-w-xs' type="text" placeholder='Enter an title'/>
            <input onChange={(e)=> setDescription(e.target.value)} value={description} className='textarea textarea-lg textarea-bordered w-full max-w-xs h-40' type="textarea" placeholder='Enter an Description' />
              <select onChange={(e)=> setType(e.target.value)} value={type} className='select select-md select-primary w-full max-w-xs'>
                {/* These options should be fetched as Enums */}
                <option disabled selected>Pick an activity type</option>
                <option>Skiing</option>
                <option>Hiking</option>
                <option>Climbing</option>
                <option>Kayaking</option>
              </select>
              <select onChange={(e)=> setFormat(e.target.value)} value={format} className='select select-md select-primary w-full max-w-xs'>
                {/* These options should be fetched as enums */}
                <option disabled selected>Pick an activity format</option>
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