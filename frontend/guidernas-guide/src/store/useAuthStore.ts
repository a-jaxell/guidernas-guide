import { UserMetadata } from 'firebase/auth';
import {create} from 'zustand';

type UserAuth = {
    user: UserMetadata | null;
    isAuthenticated: boolean; 
    login: (email: string, password: string) => Promise<void>;
    logout: () => void;
}

const useAuthStore = create<UserAuth>(set => ({
    user: null,
    isAuthenticated: false,
    login: async (email, password) => {
        // firebase login logic here
        // and on a succesful login set data below
    set({user:{ /* user data */}, isAuthenticated: true});
    },
    logout: () => {
        // Logout logic here 
        // and then set userData below
        set({user: null, isAuthenticated: false})
    }
}));

export default useAuthStore;