export class ServiceModel {
    constructor(
        public id?: any,
        public name?: string,
        public version?: string,
        public type?: string,
        public status?: string,
        public url?: string
    ) {
        this.id = id ? id : null;
        this.name = name ? name : null;
        this.version = version ? version : null;
        this.type = type ? type : null;
        this.status = status ? status : null;
        this.url = url ? url : null;
    }
}
