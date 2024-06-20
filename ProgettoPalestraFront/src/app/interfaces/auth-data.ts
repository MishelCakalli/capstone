export interface AuthData {
    token : string,
    user: {
        id: number,
        username: string,
        name: string,
        surname: string,
        role: string,
        enabled: boolean,
        authorities: [
            {
                authority: string
            }
        ],
        accountNonExpired: boolean,
        credentialsNonExpired: boolean,
        accountNonLocked: boolean
    }
}