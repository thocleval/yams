export class Track {
  constructor(
    public id: string,
    public name: string,
    public number: number,
    public duration: number,
    public played?: true,
  ) {  }
}
