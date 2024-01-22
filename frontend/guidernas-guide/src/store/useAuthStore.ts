import { auth } from '@/config/firebase';
import { Auth, User, UserCredential, signInWithEmailAndPassword } from 'firebase/auth';
import {create} from 'zustand';

type UserAuth = {
    user: User | null;
    isAuthenticated: boolean; 
    login: (email: string, password: string) => Promise<void>;
    logout: () => void;
}

const useAuthStore = create<UserAuth>(set => ({
    user: null,
    isAuthenticated: false,
    login: async (email, password) => {
        const userCredential = await signInWithEmailAndPassword(auth, email, password);
        // and on a succesful login set data below
        console.log("logged in")
    set({user: userCredential.user, isAuthenticated: true});
    },
    logout: async () => {
        // Logout logic here 
        await auth.signOut();
        console.log("logged out");
        set({user: null, isAuthenticated: false})
    }
}));

export default useAuthStore;