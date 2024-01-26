
import React from 'react'
import ActivityCreateForm from '../components/ActivityForm/ActivityForm'
import Layout from './layout'
import { Activity, ActivityFormat, ActivityType } from '@/utils/types'

const initialData: Activity = {
  id: 0,
  title: '',
  description: '',
  type: null,
  format: null,
  startTime: null,
  endTime: null,
  attendees: [],
  leaders: []
}

export default function Page(){
  return (
    <Layout>
        <div className="flex flex-col items-center justify-center h-full">
            <h1 className='text-4xl'>Test</h1>
            <ActivityCreateForm initialData={initialData} />
        </div>
        
    </Layout>
  )
}
